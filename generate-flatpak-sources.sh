#!/bin/bash

# Exit on error
set -e

# Navigate to the project root (where the script is located)
cd "$(dirname "$0")"

echo "Cleaning and running Gradle build with --info to capture dependency URLs..."
# We use :composeApp:packageDistributionForCurrentOS to trigger a build that resolves dependencies
./gradlew clean :composeApp:packageDistributionForCurrentOS --info --console plain > gradle-log.txt

echo "Generating generated-sources.json for Flatpak offline build..."
# Adjust the path to the generator script based on your project structure
# Assumes flatpak-builder-tools is in the parent directory of Word Counter
GENERATOR_SCRIPT="../flatpak-builder-tools/gradle/flatpak-gradle-generator.py"

if [ ! -f "$GENERATOR_SCRIPT" ]; then
    echo "Error: Could not find the generator script at $GENERATOR_SCRIPT"
    exit 1
fi

python3 "$GENERATOR_SCRIPT" gradle-log.txt generated-sources.json

echo "Done! generated-sources.json has been updated."
