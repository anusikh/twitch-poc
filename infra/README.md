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

- generate a stream key for a signed in user and save in db
- start streaming menu
- routing: localhost:8080/anusikh2001, should take me to anusikh2001's stream, and the video source should be set appropriately
- improve auth_service
- a home page where all online streamers can be seen
- enable audio
