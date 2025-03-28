# Spring Security Authentication API

This project demonstrates a simple authentication and authorization system using Spring Security. It manages user access to different endpoints based on role-based permissions.

## Overview

This API provides:
- Public access to the home page
- Role-based access control for different user types
- In-memory user management with predefined credentials
- Secure routing based on user roles

## Security Configuration

The application defines two user roles:
- **users**: Standard users with basic access permissions
- **managers**: Administrative users with extended access permissions

## Endpoints

| Endpoint | Method | Access | Description |
|----------|--------|--------|-------------|
| `/` | GET | Public | Home page accessible to all visitors |
| `/login` | POST | Public | Authentication endpoint |
| `/users` | GET | Users & Managers | Content restricted to authenticated users |
| `/managers` | GET | Managers only | Administrative content for managers only |

## Implementation Details

### Security Configuration

The `WebSecurityConfig` class sets up the security filter chain that controls access to different parts of the application:

```java
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Security rules configuration
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        // User definitions
    }
}
```

### Controller

The `WelcomeController` handles HTTP requests to the defined endpoints:

```java
@RestController
public class WelcomeController {
    @GetMapping
    public String welcome() {
        return "Welcome to the home page!";
    }

    @GetMapping("/users")
    public String users() {
        return "Authorized. Welcome to the users page!";
    }

    @GetMapping("/managers")
    public String managers() {
        return "Authorized. Welcome to the managers page!";
    }
}
```

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven or Gradle

### Running the Application
1. Clone the repository
2. Build the project with Maven/Gradle
3. Run the application
4. Access the application at `http://localhost:8080`

## Security Notes

- This implementation uses in-memory authentication which is suitable for development and testing but not for production environments
- The `withDefaultPasswordEncoder()` method is deprecated and should not be used in production
- For production, consider using a proper password encoder (like BCryptPasswordEncoder) and a database-backed user store

## Additional Configuration

For production environments, consider implementing:
- HTTPS enforcement
- JWT token-based authentication
- Database-backed user management
- Password encryption with BCrypt
- Cross-Origin Resource Sharing (CORS) configuration