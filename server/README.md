# Picnic Server

Ktor-based backend server for the Picnic social media platform.

## Setup

### Prerequisites

- JDK 17 or higher
- PostgreSQL 14+
- Gradle 8.x

### Database Setup

1. Create PostgreSQL database and user:

```sql
CREATE DATABASE picnic_db;
CREATE USER picnic_user WITH PASSWORD 'picnic_password';
GRANT ALL PRIVILEGES ON DATABASE picnic_db TO picnic_user;
```

2. The database schema will be created automatically on first run using Exposed ORM.

### Configuration

The server uses `application.conf` for configuration. You can override values using environment variables:

**Environment Variables:**

```bash
# Database
export DATABASE_URL="jdbc:postgresql://localhost:5432/picnic_db"
export DATABASE_USER="picnic_user"
export DATABASE_PASSWORD="picnic_password"

# JWT
export JWT_SECRET="your-secure-secret-key-change-this-in-production"

# Redis (optional, for caching)
export REDIS_HOST="localhost"
export REDIS_PORT="6379"

# Storage (AWS S3 or Cloudflare R2)
export STORAGE_TYPE="s3"
export AWS_BUCKET_NAME="picnic-media"
export AWS_REGION="us-east-1"
export AWS_ACCESS_KEY_ID="your-access-key"
export AWS_SECRET_ACCESS_KEY="your-secret-key"

# Email (SendGrid)
export SENDGRID_API_KEY="your-sendgrid-api-key"
```

### Running the Server

#### Development Mode

```bash
cd server
../gradlew run
```

The server will start at `http://localhost:8080`

#### Production Mode

```bash
cd server
../gradlew build
java -jar build/libs/server-all.jar
```

## API Endpoints

### Health Check

```bash
GET /
GET /health
```

### Authentication

#### Register
```bash
POST /api/auth/register
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "SecurePass123",
  "username": "johndoe",
  "displayName": "John Doe"
}
```

#### Login
```bash
POST /api/auth/login
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "SecurePass123"
}
```

#### Refresh Token
```bash
POST /api/auth/refresh
Content-Type: application/json

{
  "refreshToken": "your-refresh-token"
}
```

#### Logout
```bash
POST /api/auth/logout
Content-Type: application/json

{
  "refreshToken": "your-refresh-token"
}
```

### Protected Endpoints (require JWT)

#### Get Current User
```bash
GET /api/users/me
Authorization: Bearer your-access-token
```

## Password Requirements

- Minimum 8 characters
- At least one uppercase letter
- At least one lowercase letter
- At least one number

## Username Requirements

- 3-30 characters
- Letters, numbers, and underscores only
- Must be unique

## Testing

```bash
# Run all tests
../gradlew test

# Run with coverage
../gradlew test jacocoTestReport
```

## Project Structure

```
server/
├── src/main/kotlin/com/picnic/server/
│   ├── Application.kt              # Main application entry point
│   ├── data/
│   │   └── database/
│   │       ├── DatabaseFactory.kt  # Database connection
│   │       └── Tables.kt           # Database schema
│   ├── plugins/
│   │   ├── CORS.kt                 # CORS configuration
│   │   ├── Logging.kt              # Request logging
│   │   ├── Routing.kt              # Route configuration
│   │   ├── Security.kt             # JWT authentication
│   │   └── Serialization.kt        # JSON serialization
│   ├── routes/
│   │   └── AuthRoutes.kt           # Authentication endpoints
│   ├── services/
│   │   └── AuthService.kt          # Authentication business logic
│   └── util/
│       ├── JwtConfig.kt            # JWT utilities
│       └── Validators.kt           # Input validation
└── src/main/resources/
    ├── application.conf             # Server configuration
    └── logback.xml                  # Logging configuration
```

## Security Features

✅ JWT-based authentication (no social login - data stays with us)  
✅ BCrypt password hashing  
✅ Refresh token rotation  
✅ Token revocation on logout  
✅ Email and username uniqueness  
✅ Password strength validation  
✅ SQL injection prevention (Exposed ORM)  
✅ CORS configuration  
✅ Request rate limiting (planned)  

## Development

### Adding New Routes

1. Create route file in `routes/` package
2. Add route configuration in `plugins/Routing.kt`
3. Create service class in `services/` package if needed

### Adding Database Tables

1. Add table definition in `data/database/Tables.kt`
2. Update `DatabaseFactory.kt` to include new table in schema creation

## License

MIT
