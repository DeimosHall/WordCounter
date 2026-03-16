# Word Counter

A clean, modern, and private word counting app built with **Compose Multiplatform**.

<p align="center">
  <img src="screenshots/android-main-light.jpg" width="30%" style="vertical-align: middle" />
  <img src="screenshots/linux-main-dark.png" width="60%" style="vertical-align: middle" />
</p>

## Source code

- [GitHub](https://github.com/DeimosHall/WordCounter)
- [Codeberg](https://codeberg.org/deimoshall/WordCounter)

## Flatpak Maintenance

To build this app for Flathub, a `generated-sources.json` file must be maintained. This file contains the checksums for all Gradle dependencies, which are required for the offline build sandbox.

Run the following script to update the dependencies:

```bash
./generate-flatpak-sources.sh
```

**When to repeat the process:**

- Adding a new library to `build.gradle.kts` or `libs.versions.toml`.
- Updating the version of an existing library.
- Changing the Gradle version itself.
- Adding a new Gradle plugin.

## License

This project is licensed under the GPLv3 license. See the [License](LICENSE) file for more information.

## Credits

Made with ♥️ by [Deimos Hall](https://deimoshall.dev/about/).
