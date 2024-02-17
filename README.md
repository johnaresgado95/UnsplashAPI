# UNSPLASH API APP

## About
This mini project has simple functionalities but applying best code practices using Clean Architecture and MVVM pattern. 
And I also secure the CLIENT_ID using properties in gradle. 

## Feature
* Viewing List of Photos
* Viewing Photos based on users id
* Searching photos using location - work in progress

## Api Endpoints
* photos/?client_id=
* photos/id?client_id=

## Library
implementation "androidx.coordinatorlayout:coordinatorlayout:1.2.0"
implementation 'androidx.swiperefreshlayout:swiperefreshlayout:1.1.0'
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
implementation 'com.github.bumptech.glide:glide:4.13.2'
implementation 'io.reactivex.rxjava2:rxjava:2.1.12'
implementation 'com.facebook.shimmer:shimmer:0.5.0'
