# Social-Network

Social-Network is a Stateful app built with [Spring Boot](http://spring.io/projects/spring-boot), [MySQL](https://www.mysql.com/) and [React](https://reactjs.org/).

Features:
- Routing
- User authentication: Register/Login/Logout
- 3 User Roles: Root, Admin and User
- Promoting/Demoting users to Admin/User
- Creating and deleting users
- Editing user profile
- Searching for friends
- Sending and accepting friend requests
- Removing friends from the friends list
- Adding and deleting photos
- Creating and deleting posts
- Creating and deleting comments
- Chat functionality: writing and receiving messages from your friends
- Logs history

The project is deployed on [Heroku](https://social-network.herokuapp.com/).

**Admin Credentials:**
- username: john
- password: 1111

## Requirements

1. Java 11

## Start the app

### **Option 1 - Start the Client and the Server manually**

#### 1. Start the Client

To start the Client you need to enter the `SocialNetwork/Client` folder:

```bash
$ cd SocialNetwork/Client
```

Install all dependencies:

```bash
$ npm install
```

Run the app in the development mode:

```bash
$ npm start
```

Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

#### 2. Start the Server

Go to the root directory of the Spring Boot app:

```bash
$ cd SocialNetwork/Server
```

Start the Server:

```bash
$ mvn spring-boot:run
```
The Server is running on port `8000`.

## App screenshots

1. **Home Page**

 ![App Screenshot](readme-images/social-network-home-gregor.PNG)

2. **Friends Page**

 ![App Screenshot](readme-images/social-network-friends-gregor.PNG)

3. **Photos Page**

 ![App Screenshot](readme-images/social-network-photos-gregor.PNG)
