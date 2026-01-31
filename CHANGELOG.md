# Changelog
All notable changes to this project will be documented in this file.

Format mengikuti prinsip **Keep a Changelog**  
Versioning mengikuti **Semantic Versioning (SemVer)**.

---

## [v1.0.0] – 2026-01-31
### Added
- Remote configuration via static JSON (GitHub Pages)
- Cache fallback when remote config is unavailable (offline-safe)
- Branding support from config:
  - Wallpaper (`branding.wallpaperUrl`)
  - Logo (`branding.logoUrl`)
  - Property name badge (`propertyName`)
- Home Screen Zoom Overlay:
  - **WiFi Overlay**
    - SSID & password display
    - QR WiFi (scan to connect)
  - **WhatsApp Overlay**
    - Display number (local-friendly, e.g. `08xx`)
    - QR wa.me (auto-normalized to international `62xx`)
- Running text from config (`text.runningText`)
- Manual build pipeline via GitHub Actions
- Android TV–friendly fullscreen UI (Compose)

### Changed
- N/A (initial stable baseline)

### Fixed
- Safe handling of missing / empty config fields
- wa.me link compatibility with multiple number formats:
  - `08xx`, `+62xx`, `62xx`, `8xx`

### Known Limitations
- QR images rely on external QR service (internet required for initial load)
- No kiosk/admin mode yet
- No slideshow/gallery support
- No role-based UI or admin settings

---

## [Unreleased]
### Planned
- Slideshow/gallery support via config
- Kiosk mode with admin PIN
- Optional UI feature toggles via config
- QR WiFi security type configuration (WPA/WEP/nopass)

---
