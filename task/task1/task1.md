# Task 1
- Analyze the home page loading of SJTU
  - compare with other webste home page
  - carry out your optimization solution
- Write down your investigation and solution in Markdown
  - submit your repo

## Overview
### Frontend
 [交大网站](https://www.sjtu.edu.cn/)使用了html+css+js来实现前端。其中css使用了栅格布局，js使用了jQuery，简化了编程。
### Backend
 后端未知 :smile:

## Contrast
### [Tsinghua](http://www.tsinghua.edu.cn/publish/thu2018/index.html)
 - 清华官网首先在外观上完虐交大网站，不愧是有美院的清华啊。
 - 再者，清华网页的源码看起来井然有序、一目了然。


| tsinghua   | sjtu    |
| --------   | -----:   |
|![tsinghua](https://pan.baidu.com/s/1g5A9rIs7GxGF09kM47QCvw)|![sjtu](https://pan.baidu.com/s/1YLxl_yKFHzPE9R1jjBrwTw)|

 - 清华的英文版网站虽然是另外一个页面，但至少域名没变、风格一致，而交大的英文版网站不仅看起来很古老而且域名也发生了变化。
 - 但清华的网站并没有使用栅格布局，而是依靠css定义宽度、高度和像素。由于清华的程序员小哥只写了两种模式，于是在窗口大小发生变化时，页面内各组件的大小十分别扭。而交大的栅格布局可以灵活的变更每一个块的大小，这是一个优点。
 - 清华和交大的网站都使用了jQuery，而且某些被注释掉的测试代码依旧保存在源码中。此外，两个网站都没有完全将script分离出来，交大更甚。
 ### [Peking University](https://www.pku.edu.cn/)
 - 北大官网和交大官网从外观层面较为相似，且英文版页面都更换了域名，但北大的中英文页面属于一个风格。
 - 结构位于交大和清华之间，其余基本和清华一致

 ### Conclusion
 各高校的官网总体来说没有太大的差别，在格式方面交大做得比较先进，在其他方面还是和各高校一样古老，有可能是写网站的时候还没有出现新的技术，比如vue、react框架，axios等。
 ## Optimization
 - 首先是可以把javascript全部写进js文件。
 - 其次可以更新一下，使用新的框架来编写。
 - 数据与前端渲染分离。一些即时改变的新闻数据和一些参考网站的数据可以放在后端而不是让前端既完成渲染页面的工作又存储大量数据。这样能使前端的工作缩小、简单、单一，符合micro service的原则。


