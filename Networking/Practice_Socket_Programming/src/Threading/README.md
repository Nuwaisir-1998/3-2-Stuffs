## Server
Here we have a time server. Once connected, this server will keep sending the current time to the client each second. Also, this server can serve multiple client. For this, we use thread. Once a connection is established, we create a thread in server side to handle the client. The main-thread will continue to listen for new connection in the ``welcomeSocket``.

## Client
As server will keep sending the current time in each passing seconds, client too will keep reading the data. We have two client to show that server can serve both of them simultaneously.