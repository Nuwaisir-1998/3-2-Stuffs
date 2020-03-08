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

5. Updated code... previously I passed socket to server thread, but now I'm making a 
   SocketDetail object first and then sending that to the thread constrcutor. The 
   reason is: if I need to make more threads from Server class, I would need the 
   same socket made for a particular connection. So, first I make the socketDetail 
   and pass that to all threads, otherwise, if I pass only socket, I would need to 
   create socketDetail class again and that will cause exception because an 
   ObjectOutputStream was previously declared for another thread. 
 
6. Now the buggy part, server can send message to all clients... but the sending
   is not working properly. Sometimes need to type message twice to get it delivered.
   
		
