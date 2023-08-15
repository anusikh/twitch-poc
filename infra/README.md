- we are using nginx-rmtp docker image with our own nginx.conf
- the rmtp url on obs is `rmtp://localhost:1935/live`
- the plan is to handle auth in thymeleaf app and generate a unique stream key for a user and store it in db
- then the user can get that key and use it in obs i.e `<USER_NAME>?key=<KEY_VALUE>` add this to the key textbox
- authserver checks if that key is available in db and authenticates the stream
- in vlc, to connect to stream `rmtp://localhost:1935/live/<USER_NAME>`
- we then make changes to nginx.conf to enable hls so that we can view the stream in brower/phones

TODO:
[] try to dockerize the thymeleaf app
[] i can see the m3u8 file generated in data folder, figure how to display that stream
