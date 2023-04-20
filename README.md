# SS_Raft
Try to write an Raft.

## 1.Raft简介
Raft是一个用于管理日志一致性的协议。它将分布式一致性分解为多个子问题：Leader选举（Leader election）、日志复制（Log replication）、安全性（Safety）、日志压缩（Log compaction）等。
同时，Raft算法使用了更强的假设来减少了需要考虑的状态，使之变的易于理解和实现。Raft将系统中的角色分为领导者（Leader）、跟从者（Follower）和候选者（Candidate）：
*  Leader：接受客户端请求，并向Follower同步请求日志，当日志同步到大多数节点上后告诉Follower提交日志。
* Follower：接受并持久化Leader同步的日志，在Leader告之日志可以提交之后，提交日志。
* Candidate：Leader选举过程中的临时角色。

Raft要求系统在任意时刻最多只有一个Leader，正常工作期间只有Leader和Followers。Raft算法将时间分为一个个的任期（term），每一个term的开始都是Leader选举。
在成功选举Leader之后，Leader会在整个term内管理整个集群。如果Leader选举失败，该term就会因为没有Leader而结束。

## 2.Term

Raft 算法将时间划分成为任意不同长度的任期（term）。任期用连续的数字进行表示。每一个任期的开始都是一次选举（election），一个或多个候选人会试图成为领导人。
如果一个候选人赢得了选举，它就会在该任期的剩余时间担任领导人。在某些情况下，选票会被瓜分，有可能没有选出领导人，那么，将会开始另一个任期，并且立刻开始下一次选举。
Raft 算法保证在给定的一个任期最多只有一个领导人。

## 3.RPC

Raft 算法中服务器节点之间通信使用远程过程调用（RPC），并且基本的一致性算法只需要两种类型的 RPC，为了在服务器之间传输快照增加了第三种 RPC。
* RequestVote RPC：候选人在选举期间发起。
* AppendEntries RPC：领导人发起的一种心跳机制，复制日志也在该命令中完成。
* InstallSnapshot RPC: 领导者使用该RPC来发送快照给太落后的追随者。