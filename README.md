# 🧺 Picnic

A next-generation social media platform built with Kotlin Multiplatform and Compose Multiplatform, featuring hybrid feeds, collaborative albums, and creator monetization.

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.20-blue.svg)](https://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-1.5.10-green.svg)](https://www.jetbrains.com/lp/compose-multiplatform/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## ✨ Features

### Core Features
- **Hybrid Feed** - Visual vibes meet chatty corners in a unified experience
- **Baskets** - Collaborative albums where friends co-curate content together
- **Hangouts** - Community groups for shared interests and conversations
- **Clips** - Short-form video content with effects and audio
- **Stories** - 24-hour ephemeral content with highlights
- **Direct Messaging** - Real-time chat with individuals and groups

### Social Features
- **Mutual Followship** - Friendships established through mutual follows
- **Interactions** - Likes, comments, shares, bookmarks, and reactions
- **Search & Discovery** - Find users, posts, hashtags, and trending topics
- **Location Tagging** - Check-ins and geotags for posts

### Creator Features
- **Subscription Tiers** - Monetize content with custom subscription levels
- **Analytics Dashboard** - Track engagement, reach, and earnings
- **Verification System** - Blue check verification for creators
- **Payouts** - Direct earnings management and withdrawal

### Safety & Privacy
- **Content Moderation** - Report system for inappropriate content
- **Age Verification** - ID verification for 18+ content and subscriptions
- **Blocking & Privacy** - Control who sees your content
- **Secure Authentication** - JWT-based auth with refresh tokens

## 🏗️ Architecture

### Technology Stack
- **Client**: Kotlin Multiplatform + Compose Multiplatform
- **Backend**: Ktor (Kotlin)
- **Database**: PostgreSQL + Redis (caching)
- **Storage**: AWS S3 / Cloudflare R2
- **Real-time**: WebSockets
- **Payments**: Stripe
- **Push Notifications**: FCM (Android) + APNs (iOS)

### Project Structure
```
picnic-app/
├── composeApp/          # Shared UI and business logic
│   └── src/
│       ├── commonMain/  # Shared code for all platforms
│       ├── androidMain/ # Android-specific implementations
│       ├── iosMain/     # iOS-specific implementations
│       ├── desktopMain/ # Desktop-specific implementations
│       └── wasmJsMain/  # Web-specific implementations
├── server/              # Ktor backend server
├── iosApp/              # iOS app wrapper
└── shared/              # Shared modules
```

### Clean Architecture Layers
1. **Domain Layer** - Business logic, models, use cases
2. **Data Layer** - Repositories, API clients, local database
3. **Presentation Layer** - UI screens, ViewModels, components

## 🚀 Getting Started

### Prerequisites
- JDK 17 or higher
- Android Studio Hedgehog (2023.1.1) or later
- Xcode 15+ (for iOS development)
- Kotlin 1.9.20+

### Clone the Repository
```bash
git clone https://github.com/yourusername/picnic-app.git
cd picnic-app
```

### Running on Different Platforms

#### Android
```bash
./gradlew :composeApp:assembleDebug
./gradlew :composeApp:installDebug
```

#### iOS
```bash
cd iosApp
pod install
open iosApp.xcworkspace
```
Then run from Xcode.

#### Desktop
```bash
./gradlew :composeApp:run
```

#### Web (WASM)
```bash
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

### Backend Setup

#### 1. Configure Database
Create a PostgreSQL database:
```sql
CREATE DATABASE picnic_db;
CREATE USER picnic_user WITH PASSWORD 'your_password';
GRANT ALL PRIVILEGES ON DATABASE picnic_db TO picnic_user;
```

#### 2. Update Configuration
Edit `server/src/main/resources/application.conf`:
```hocon
ktor {
    deployment {
        port = 8080
    }
}

database {
    url = "jdbc:postgresql://localhost:5432/picnic_db"
    user = "picnic_user"
    password = "your_password"
}

jwt {
    secret = "your-jwt-secret"
    issuer = "picnic-app"
    audience = "picnic-users"
}
```

#### 3. Run Server
```bash
cd server
./gradlew run
```

Server will start at `http://localhost:8080`

## 🧪 Testing

### Run All Tests
```bash
./gradlew test
```

### Run Specific Platform Tests
```bash
./gradlew :composeApp:testDebugUnitTest  # Android
./gradlew :composeApp:iosSimulatorArm64Test  # iOS
```

## 📦 Building for Production

### Android
```bash
./gradlew :composeApp:assembleRelease
```
APK location: `composeApp/build/outputs/apk/release/`

### iOS
Build from Xcode with Release configuration or:
```bash
xcodebuild -workspace iosApp.xcworkspace \
  -scheme iosApp \
  -configuration Release \
  archive -archivePath build/iosApp.xcarchive
```

### Desktop
```bash
./gradlew :composeApp:packageDistributionForCurrentOS
```

### Web
```bash
./gradlew :composeApp:wasmJsBrowserDistribution
```

## 🔑 Environment Variables

Create a `.env` file in the root directory:
```env
# Server
SERVER_PORT=8080
DATABASE_URL=jdbc:postgresql://localhost:5432/picnic_db
DATABASE_USER=picnic_user
DATABASE_PASSWORD=your_password
JWT_SECRET=your-jwt-secret

# Storage
AWS_ACCESS_KEY_ID=your-access-key
AWS_SECRET_ACCESS_KEY=your-secret-key
AWS_BUCKET_NAME=picnic-media

# Payments
STRIPE_SECRET_KEY=sk_test_xxx
STRIPE_PUBLISHABLE_KEY=pk_test_xxx

# Push Notifications
FCM_SERVER_KEY=your-fcm-key
APNS_KEY_ID=your-apns-key-id
APNS_TEAM_ID=your-team-id

# Email
SENDGRID_API_KEY=your-sendgrid-key
```

## 🎨 Design System

### Colors
- Primary: Yellow to Green gradient (`#F4FF6C` → `#7CFF6C`)
- Background: `#000000` (Dark mode first)
- Surface: `#1A1A1A`
- Text: `#FFFFFF`

### Typography
- Heading: Custom rounded font
- Body: System default (SF Pro / Roboto)

### Components
All UI components follow the Picnic design system with consistent spacing, colors, and interactions.

## 🤝 Contributing

We welcome contributions! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Code Style
- Follow [Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html)
- Use meaningful variable names
- Write tests for new features
- Document public APIs

## 📄 API Documentation

API documentation is available at `http://localhost:8080/docs` when running the server.

### Authentication
All authenticated endpoints require a Bearer token:
```bash
curl -H "Authorization: Bearer YOUR_TOKEN" \
  http://localhost:8080/api/feed
```

### Key Endpoints
- `POST /api/auth/login` - User login
- `POST /api/auth/register` - User registration
- `GET /api/feed` - Get user feed
- `POST /api/posts` - Create post
- `GET /api/users/:id` - Get user profile
- `POST /api/baskets` - Create collaborative basket
- `GET /api/hangouts` - List hangouts

## 🔒 Security

- Passwords are hashed using bcrypt
- JWT tokens expire after 24 hours
- Refresh tokens for extended sessions
- Rate limiting on all endpoints
- CORS configured for production
- SQL injection prevention via Exposed ORM
- XSS protection in sanitized inputs

## 📱 Platform Support

| Platform | Status | Min Version |
|----------|--------|-------------|
| Android  | ✅ Stable | API 24 (Android 7.0) |
| iOS      | ✅ Stable | iOS 14.0+ |
| Desktop  | ✅ Beta | Windows 10, macOS 11, Linux |
| Web      | 🚧 Alpha | Modern browsers (WASM support) |

## 🐛 Known Issues

- WASM web target has limited file upload support
- iOS biometric authentication requires real device
- Desktop notifications require platform-specific permissions

## 📊 Performance

- App startup time: < 2 seconds
- Feed load time: < 500ms (with caching)
- Image upload: Supports up to 20MB
- Video upload: Supports up to 100MB (auto-compression)

## 📚 Documentation

- [Architecture Guide](docs/ARCHITECTURE.md)
- [API Reference](docs/API.md)
- [Component Library](docs/COMPONENTS.md)
- [Deployment Guide](docs/DEPLOYMENT.md)

## 📞 Support

- Email: support@picnic-app.com
- Discord: [Join our community](https://discord.gg/picnic)
- Twitter: [@PicnicApp](https://twitter.com/picnicapp)

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Kotlin Multiplatform team at JetBrains
- Compose Multiplatform community
- All open-source contributors

## 🗺️ Roadmap

- [ ] v1.0 - Core features (Feed, Baskets, Hangouts, Clips)
- [ ] v1.1 - Subscription monetization
- [ ] v1.2 - Advanced analytics
- [ ] v1.3 - Live streaming
- [ ] v1.4 - E-commerce integration
- [ ] v2.0 - AI-powered recommendations

---

Built with ❤️ using Kotlin Multiplatform

**Status**: 🚧 In Development | **Version**: 0.1.0-alpha
