NOTES:

- we are using nginx-rmtp docker image with our own nginx.conf
- the rmtp url on obs is `rmtp://localhost:1935/live`
- the plan is to handle auth in thymeleaf app and generate a unique stream key for a user and store it in db
- then the user can get that key and use it in obs i.e `<USER_NAME>?key=<KEY_VALUE>` add this to the key textbox
- authserver checks if that key is available in db and authenticates the stream
- in vlc, to connect to stream `rmtp://localhost:1935/live/<USER_NAME>`
- we then make changes to nginx.conf to enable hls so that we can view the stream in brower/phones
- in vlc, connect to this url to view the stream: `http://localhost:8081/hls/<USER_NAME>.m3u8`

- the nginx.conf contains a server running at port 8081, that returns the above http call to fetch the m3u8 stream file
- we assign it to the video source in home.html and now u can see the stream

TODO:

- run the jar in a container [DONE]
- generate a stream key for a signed in user and save in db
  - for this, every time a new account is created, a stream key will be generated and stored in the db [DONE]
  - `<USER_NAME>?key=<KEY_VALUE>` from this in obs, we get the streamer's username and the stream key [DONE]
  - we will fetch data for that user from the db and compare if the received streamer key is same as the key passed [DONE]
  - if so, user will be able to connect to stream [DONE]
  - routing: localhost:8080/anusikh2001, should take me to anusikh2001's stream, and the video source should be set appropriately [DONE]
- a home page where all online streamers can be seen
  - create a html page/route that shows the stream key [DONE]
  - fix the styling in the current pages
  - figure out the online and offline mechanism
  - also make homepage accessible to all, with options to login and register
- start streaming menu
- improve auth_service
- enable audio [DONE] automatically hanled by rtmp
