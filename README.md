# GitHub API Wrapper

A Spring Boot application that interacts with the GitHub API to fetch repository details, including branches and their last commit SHA for a given GitHub user.

## Features

- Fetches repositories of a given GitHub user
- Retrieves branches and their last commit SHA for each repository
- Handles various HTTP errors with custom exceptions

## Prerequisites

- Java 11 or higher
- Maven
- GitHub API token with necessary scopes

## Getting Started

### 1. Clone the Repository

```sh
git clone https://github.com/yourusername/github_wrapper.git
cd github_wrapper
```

### 2. Set Up Environment Variables

Set your GitHub API token as an environment variable:

On Windows:
```sh
set GITHUB_API_TOKEN=your_github_token
```
On macOS/Linux:
```sh
export GITHUB_API_TOKEN=your_github_token
```

To setup your Github Token visit:

  -[GitHub App user access tokens](https://docs.github.com/en/apps/creating-github-apps/authenticating-with-a-github-app/generating-a-user-access-token-for-a-github-app)
  <br>
  -[GitHub App installation access tokens](https://docs.github.com/en/apps/creating-github-apps/authenticating-with-a-github-app/generating-an-installation-access-token-for-a-github-app)
  <br>
  -[Fine-grained personal access tokens](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens#creating-a-fine-grained-personal-access-token)

### 4. Build and Run the Application

Use Maven to build and run the application:

```sh

mvn clean install
mvn spring-boot:run
```
### 5. Access the API

Use the following endpoint to get the repositories and their branch details for a specific GitHub user:

```sh
GET http://localhost:8080/api/v1/github/{username}
```
Example:

```sh
curl http://localhost:8080/api/v1/github/aftermath321
```
### License

This project is licensed under the MIT License.
