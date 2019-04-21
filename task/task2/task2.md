# Task 2
- Find the resources consumption of your REST service
  - Run your service on your desktop or laptop
  - Get the CPU、Memory consumpution of it when there is no requests
  - With the increasing requests, find out the trend of each resource utilization
- Write a report in Markdown

## Tools Introduction
### Mac
 ![活动监视器](./pic1.png)
### Linux
 `top`、`free`指令

## Main Work
### when there is no requests
 [没有外部请求下的cpu占用率和内存使用情况以及网络情况](./norequests.mov)
- 可以看出，在没有请求的条件下，只运行`/hw/hw2`的IntelliJ的cpu占用率大致在`3.5%～4.5%`,内存维持在`980MB`左右，网络通讯由一开始接收字节多于发送字节渐渐变成发送字节多于接收字节。
- 随着时间延长，内存使用增加（在编辑完`when there is no request`部分后，内存已变为`1.39GB`）
### when requests increase
 [ab - Apache HTTP server benchmarking tool](http://httpd.apache.org/docs/2.2/programs/ab.html)

 [外部请求不断增加时cpu占用率和内存使用情况](./inrequests.mov)

> 请求序列：
```aidl
ab -n 10 -c 3 -A ruirui:renrui http://localhost:8080/login
```
```aidl
ab -n 100 -c 10 -A ruirui:renrui http://localhost:8080/login
```
```aidl
ab -n 1000 -c 100 -A ruirui:renrui http://localhost:8080/login
```
```aidl
ab -n 10000 -c 100 -A ruirui:renrui http://localhost:8080/login
```
```aidl
ab -n 100 -c 10 -A ruirui:renrui http://localhost:8080/management
```
```aidl
ab -n 1000 -c 100 -A ruirui:renrui http://localhost:8080/management
```
- 【/login】当请求量较小时，cpu占用率没有太大波动，但当100个用户同时请求10000次时，cpu占用率有了明显波动，即迅速见减小再迅速回增。
- 【/management】同样参数下，反应速度更慢，cpu占用率变化趋势相同。