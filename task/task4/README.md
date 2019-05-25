### Task IV
- Implement a container in Java
    - Properties
        - Threshold
            - If the number of items in the container is less then
                - Queue
            - Else
                - Stack
        - Timeout
            - If the time that a item is staying in the container is longer than timeout
                - Remove it
    - Write a producer and a consumer to evaluate your container
        - Multi producers, multi consumers
- Deadline
    - Before May 27, 2019
#### Implementation
##### File Tree
First let me introduce with the file tree:
```aidl
.
├── README.md
├── blackMQ.iml
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── Broker.java
│   │   │   ├── BrokerServer.java
│   │   │   ├── ConsumeClient.java
│   │   │   ├── MqClient.java
│   │   │   ├── MyMessage.java
│   │   │   └── ProduceClient.java
│   │   └── resources
│   └── test
│       └── java
└── target
    ├── classes
    │   ├── Broker.class
    │   ├── ...
    └── generated-sources
        └── annotations

11 directories, 17 files
```
There are 6 main java files: `Broker.java`,`BrokerServer.java`,
`ConsumeClient.java`,`MqClient.java`,`MyMessage.java`,`ProduceClient.java`.

In `MyMessage.java`, I wrapped the `String` class for message, 
`Pair<String,Integer>` class for recording the position of this `MyMessage`
in container and `Timer` class for alarm to update the messages in container.

In `Broker.java`, I support `produce` and `consume` function. 
Besides, it has two queue as its member variables: `ConcurrentLinkedQueue`
 and `ConcurrentLinkedDeque` respectively.
 The former for `FIFO` queue and the latter for `LIFO` stack. And 
 both are thread safe.

In `BrokerServer.java`, it is the main program to start new thread
to accept producer client and consumer client using socket.

In `MqClient.java`, it is in charge of communication with `BrokerServer`,
providing `produce` and `consume` function for `ProduceClient` and `ConsumeClient`.

In `ProduceClient.java`, I create 5 threads to produce messages.
In `ConsumeClient.java`, I create only one consumer to consume messages.
If you'd like to multiple consumers, just modify the `main` function
in this file using `for` loop and `new Thread(..).start()`.
##### Arguments 
The `Threshold` argument is record in `Broker.java` as a static variable.
You can modify it as you like.
The `Timeout` argument is record in `MyMessage.java` naming `delay`, 
whose unit is millisecond.
##### Strategies
For producer, I first check if the `FIFO` queue is full, 
and place the message in `ConcurrentLinkedQueue` if not, otherwise
place it in `ConcurrentLinkedQueue`.

For consumer, it will consume all messages in container at once.

For update, I make tricks on the time and queue. 
For detailed, I recommend you look into code blocks.  
##### ShortComings
- `size()` in both `ConcurrentLinkedQueue` and `ConcurrentLinkedQueue`
are O(n) complexity.
- All the messages are stored in memory, so it has no persistence.
##### Output
```aidl
# produce
get message: SEND:0x1.2a78bcf201e5dp-1-10 Hello broker
succeed in offering: SEND:0x1.2a78bcf201e5dp-1-10 Hello broker

now there are 45 messages.
----------------
# update
update: remove SEND:0x1.ae8b9d5bac9f8p-2-3 Hello World
now there are 35 messages.
# consume
获取的消息为：SEND:0x1.2a78bcf201e5dp-1-10 Hello broker
SEND:0x1.2a78bcf201e5dp-1-9 Hello World
SEND:0x1.ae8b9d5bac9f8p-2-10 Hello broker
SEND:0x1.f81db6261a1bp-5-10 Hello broker
SEND:0x1.4d957f5083a7p-1-10 Hello broker
SEND:0x1.df86c3edc54dap-2-10 Hello broker
SEND:0x1.2a78bcf201e5dp-1-8 Hello broker
SEND:0x1.ae8b9d5bac9f8p-2-9 Hello World
SEND:0x1.4d957f5083a7p-1-9 Hello World
SEND:0x1.f81db6261a1bp-5-9 Hello World
SEND:0x1.df86c3edc54dap-2-9 Hello World
SEND:0x1.2a78bcf201e5dp-1-7 Hello World
SEND:0x1.4d957f5083a7p-1-8 Hello broker
SEND:0x1.f81db6261a1bp-5-8 Hello broker
SEND:0x1.2a78bcf201e5dp-1-6 Hello broker
SEND:0x1.ae8b9d5bac9f8p-2-8 Hello broker
SEND:0x1.df86c3edc54dap-2-8 Hello broker
SEND:0x1.2a78bcf201e5dp-1-5 Hello World
SEND:0x1.4d957f5083a7p-1-7 Hello World
SEND:0x1.f81db6261a1bp-5-7 Hello World
SEND:0x1.df86c3edc54dap-2-7 Hello World
SEND:0x1.ae8b9d5bac9f8p-2-7 Hello World
```