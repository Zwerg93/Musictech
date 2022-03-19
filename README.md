# musictech

This is a simple website to stream your own music
My goal is to make a application which you can clone and run localy on your own server. Its like a Nextcloud for mp3 or Music files

!!! You have to install your own database and config it in the Application properties in the Server folder!!!

right now you have to install Angular and type 'ng serve --host 0.0.0.0' 

to execute the server, you have to type 'mvn quarkus:dev'
!!! you have to config maven home and have to install java 17, and set java home"!!!

when i release the first version, everything will work with docker and run native on your linux device


# todo

Design!
Add profile side
add possibility to update your Profile and see your stats
add possibility to delete files, add them to a playlist
add possibility to create new playlists
add function to play songs after the last one has stopped
add algorithm for favourite songs (and maybe for searching songs)
add volumne slider
add feedack for user when he uses a feature of the app (like upload, add to playlist and so on)
mark songs which are in the favourits playlist with a filled heart
get rid of the bootstrap look (color and so on)
work on the design for pc and laptops
CI/CD
make a docker file to start everything (server, client and database) and maybe run everything naitive
release a first executable file 
