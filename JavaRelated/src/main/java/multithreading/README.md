There are 3 main issues that we may come across with multithreading

1. Race Condition
2. Update Visibility / Memory Visibility / Caching
3. Compiler and Cpu Operations

And we have 3 solutions to solve these issues

1. synchronized keyword (solves 1, 2, 3 but expensive)
2. volatile keyword (solves 2, 3)
3. atomic variables (solves 1, 2, 3 but only for limited conditions)
    1. Though atomic variables are not a replacement for synchronized or volatile keyword
    2. It suits perfectly in some cases, where a critical section is limited to updating a single variable
    3. using an atomic variable allows you to write lock-free and more scalable code in Java

RESULT: The most reasonable option is synchronized key even though it is an expensive operation.

RACE CONDITION

1. At the same time multiple threads can try to change the value of a variable
2. For instance, let's assume that there are 2 threads, and they try to increment a variable
3. Both of them read the value as 1, so they will want the variable to make 2 because they do it at the same time.
4. In order to prevent this we need atomicity which means doing the incrementation like just 1 transaction whereas there
   are 3 things are doing actually
5. first read the latest value, second increment it, and finally write it with the latest condition
6. To make the process atomic we use either synchronized keyword or Atomic-variables

IMPORTANT NOTE: Volatile keyword can not solve race condition problem, volatile solves only update visibility and
compiler / cpu operation problems

UPDATE VISIBILITY or MEMORY VISIBILITY problem

1. OS may schedule the threads on different CPU cores.
2. Let's assume one of the thread changes some value meaning writing a new value on the memory
3. Write requests won't be applied right away after they're issued.
4. At the first step, processors add those changes on a queue, and they wait until the queue is full
5. Shortly there is no guarantee that all threads will see the change
6. The other thread may not see the change immediately or even forever.
7. To prevent this we may use volatile keyword, it does not let the thread holding the variable in its local cache of
   the thread.
8. The variables creating with volatile always stand on the main memory



  