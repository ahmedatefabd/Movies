# Movies App

Simple Movies app , I will apply every architecture component on a separate branch with steps.

-----------------------

##  API Hints

To fetch popular movies, you will use the API from themoviedb.org.
If you don’t already have an account, you will need to [create one](https://www.themoviedb.org/account/signup) in order to request an API Key. 
   
In your request for a key, state that your usage will be for educational/non-commercial use. You will also need to provide some personal information to complete the request. Once you submit your request, you should receive your key via email shortly after.

--------------------------------

### API Key Note
You need to insert your API key.
Go to a file named `Constants.java` and find the value of API_KEY.
Replace "test" with "YOUR-API-KEY".
```
public static final String API_KEY = "YOUR-API-KEY";
```
    
In order to request popular movies you will want to request data from the /movie/popular [documentation](https://developers.themoviedb.org/3/discover/movie-discover). An API Key is required.
Once you obtain your key, you append it to your HTTP request as a URL parameter like so:
http://api.themoviedb.org/3/movie/popular?api_key=[YOUR_API_KEY]

--------------------------------
### Features

##   1-DataBinding Branch [tutorial](https://developer.android.com/topic/libraries/data-binding)

The Data Binding Library is a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.

Note: That DataBinding Branch contail all ToDo steps
and DataBindingRseult Branch contain the final result without ToDo 
##### you can accumulate on BaseProject branch and follow ToDo steps

--------------------------------

## 2- ViewModel Branch [tutorial](https://developer.android.com/topic/libraries/architecture/viewmodel)

- The ViewModel class is designed to separate out view data ownership from UI controller logic.
- The ViewModel class allows data to survive configuration changes such as screen rotations using LiveDate.

On This branch we will develop the first one and develop the second feature on LiveData branch

##### Note: you can accumulate on DataBindingRseult branch and follow ToDo steps

--------------------------------

## 3- LiveData Branch [tutorial](https://developer.android.com/topic/libraries/architecture/livedata)

is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services. This awareness ensures LiveData only updates app component observers that are in an active lifecycle state.

--------------------------------

## 4- Dagger2 Branch [tutorial](https://dagger.dev/)

Dagger is a fully static, compile-time dependency injection framework for both Java and Android. It is an adaptation of an earlier version created by Square and now maintained by Google.

--------------------------------

## 5- Retrofit Branch [tutorial](https://square.github.io/retrofit/)

Type-safe HTTP client for Android and Java by Square, Inc.

For more information please see [the website](https://square.github.io/retrofit/).

--------------------------------

## 6- Room Branch [tutorial](https://developer.android.com/training/data-storage/room/index.html)

Room provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.

--------------------------------

![image](https://i.imgur.com/xr4nzpD.png)

--------------------------------

![image](https://i.imgur.com/p3RZayW.png)


--------------------------------

![image](https://i.imgur.com/X3NXR7p.png)


