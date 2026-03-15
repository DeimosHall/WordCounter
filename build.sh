#!/bin/bash

# Get the operating system
OS_TYPE="$(uname -s)"

echo "Detected OS: $OS_TYPE"

case "${OS_TYPE}" in
    Linux*)
        echo "Building Linux installers (DEB, RPM, AppImage)..."
        ./gradlew :composeApp:packageReleaseDistributionForCurrentOS
        ;;
    Darwin*)
        echo "Building macOS installer (DMG)..."
        ./gradlew :composeApp:packageReleaseDistributionForCurrentOS
        ;;
    MINGW*|MSYS*|CYGWIN*)
        echo "Building Windows installer (MSI)..."
        ./gradlew :composeApp:packageReleaseMsi
        ;;
    *)
        echo "Unsupported OS: ${OS_TYPE}"
        exit 1
        ;;
esac

if [ $? -eq 0 ]; then
    echo "------------------------------------------------"
    echo "Build successful!"
    echo "Installers can be found in: composeApp/build/compose/binaries/main/"
else
    echo "------------------------------------------------"
    echo "Build failed. Please check the logs above."
    exit 1
fi
