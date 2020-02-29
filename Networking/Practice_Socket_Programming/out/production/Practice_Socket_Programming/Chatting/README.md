1. Clients get connected to server.
2. Every socket created when this connection are passed to a thread.
   So, if 3 clients connect with server, there are 3 threads running, each having 
   the server side socket.
3. So, the main server class and all the threads created are running simultaneously.
4. A client sends a message to the server, server then sends the message to every other
   clients connected to the server. To implement this, server needs the sockets of 
   every other connection. So, we have an ArrayList of a user defined class named 
   SocketDetails, which has the socket, ObjectInputStream, and ObjectOutputStream.
   Why do we need this class? An arrayList of sockets should do the work, isn't it?
   Mmm... I tried that earlier, but an exception was occuring. Because I was declaring 
   ObjectOutputStream for a socket more than once. I'm actually not sure that whether 
   it is possible to implement using only arrayList of sockets... (I don't know much).
		
