# Test project to demonstrate Hopfield Networks

## Implemented Hopfield Networks in the scope of classic exam scheduling problem. The results and findings are described below.

Samvel Topuzyan

Here are min clashes observed for both datasets, different slots, shifts, iterations.

### File: ute-s-92.stu

Slots: 11

| shifts/iterations | 8   | 128 | 1024 | 8196 |
|-------------------|-----|-----|------|------|
| 1                 | 988 | 434 | 434  | 434  |
| 2                 | 76  | 12  | 12   | 12   |
| 3                 | 0   | 0   | 0    | 0    |
| 4                 | 0   | 0   | 0    | 0    |
| 5                 | 0   | 0   | 0    | 0    |
| 6                 | 0   | 0   | 0    | 0    |
| 7                 | 0   | 0   | 0    | 0    |
| 8                 | 0   | 0   | 0    | 0    |
| 9                 | 0   | 0   | 0    | 0    |
| 10                | 0   | 0   | 0    | 0    |
| 11                | 0   | 0   | 0    | 0    |

Slots: 10

| shifts/iterations | 8   | 128 | 1024 | 8196 |
|-------------------|-----|-----|------|------|
| 1                 | 988 | 478 | 478  | 478  |
| 2                 | 50  | 14  | 14   | 14   |
| 3                 | 24  | 2   | 2    | 2    |
| 4                 | 2   | 0   | 0    | 0    |
| 5                 | 2   | 2   | 2    | 2    |
| 6                 | 2   | 2   | 2    | 2    |
| 7                 | 0   | 0   | 0    | 0    |
| 8                 | 0   | 0   | 0    | 0    |
| 9                 | 0   | 0   | 0    | 0    |
| 10                | 2   | 2   | 2    | 2    |

Slots: 9

| shifts/iterations | 8   | 128 | 1024 | 8196 |
|-------------------|-----|-----|------|------|
| 1                 | 988 | 526 | 526  | 526  |
| 2                 | 102 | 68  | 68   | 68   |
| 3                 | 14  | 14  | 14   | 14   |
| 4                 | 8   | 6   | 6    | 4    |
| 5                 | 12  | 12  | 12   | 2    |
| 6                 | 4   | 4   | 4    | 4    |
| 7                 | 6   | 6   | 2    | 2    |
| 8                 | 6   | 2   | 2    | 2    |
| 9                 | 10  | 10  | 10   | 10   |

Slots: 8

| shifts/iterations | 8    | 128 | 1024 | 8196 |
|-------------------|------|-----|------|------|
| 1                 | 1012 | 580 | 580  | 580  |
| 2                 | 92   | 64  | 64   | 64   |
| 3                 | 78   | 50  | 50   | 50   |
| 4                 | 24   | 24  | 24   | 24   |
| 5                 | 28   | 26  | 24   | 24   |
| 6                 | 22   | 16  | 16   | 16   |
| 7                 | 26   | 18  | 14   | 10   |
| 8                 | 24   | 24  | 24   | 24   |

Slots: 7

| shifts/iterations | 8    | 128 | 1024 | 8196 |   
|-------------------|------|-----|------|------|   
| 1                 | 1038 | 660 | 660  | 660  |   
| 2                 | 256  | 104 | 104  | 104  |   
| 3                 | 158  | 120 | 118  | 118  |   
| 4                 | 92   | 84  | 84   | 82   |   
| 5                 | 106  | 66  | 66   | 66   |   
| 6                 | 82   | 46  | 46   | 46   |   
| 7                 | 56   | 56  | 56   | 56   |
#
### File car-f-92.stu:
Slots: 32

| shifts/iterations | 8     | 128   | 1024  | 8196  |   
|-------------------|-------|-------|-------|-------|   
| 1                 | 39518 | 22066 | 17934 | 17934 |   
| 2                 | 14648 | 1730  | 1730  | 1730  |   
| 3                 | 5350  | 732   | 732   | 732   |   
| 4                 | 1538  | 526   | 526   | 526   |   
| 5                 | 1388  | 528   | 528   | 528   |   
| 6                 | 1240  | 200   | 200   | 200   |   
| 7                 | 914   | 376   | 376   | 376   |
| 8                 | 778   | 366   | 366   | 366   |
| 9                 | 660   | 346   | 346   | 346   |
| 10                | 738   | 150   | 150   | 150   |
| 11                | 558   | 304   | 294   | 294   |
| 12                | 498   | 128   | 128   | 128   |
| 13                | 478   | 322   | 262   | 262   |
| 14                | 504   | 112   | 112   | 112   |
| 15                | 380   | 254   | 254   | 242   |
| 16                | 406   | 296   | 296   | 296   |
| 17                | 368   | 262   | 236   | 212   |
| 18                | 332   | 124   | 124   | 124   |
| 19                | 290   | 252   | 236   | 180   |
| 20                | 272   | 116   | 116   | 116   |
| 21                | 378   | 242   | 198   | 198   |
| 22                | 256   | 124   | 96    | 96    |
| 23                | 276   | 202   | 202   | 170   |
| 24                | 286   | 246   | 246   | 246   |
| 25                | 338   | 232   | 186   | 160   |
| 26                | 326   | 102   | 94    | 94    |
| 27                | 390   | 196   | 168   | 156   |
| 28                | 320   | 120   | 120   | 120   |
| 29                | 388   | 200   | 174   | 152   |
| 30                | 266   | 98    | 86    | 86    |
| 31                | 294   | 178   | 172   | 156   |
| 32                | 520   | 520   | 520   | 520   |

Slots: 31

| shifts/iterations | 8     | 128   | 1024  | 8196  |   
|-------------------|-------|-------|-------|-------|   
| 1                 | 39518 | 22088 | 17998 | 17998 |   
| 2                 | 14648 | 954   | 954   | 954   |   
| 3                 | 5350  | 756   | 756   | 756   |   
| 4                 | 2148  | 660   | 660   | 660   |   
| 5                 | 1488  | 608   | 608   | 546   |   
| 6                 | 1310  | 522   | 480   | 480   |   
| 7                 | 1120  | 538   | 538   | 538   |
| 8                 | 844   | 500   | 460   | 460   |
| 9                 | 920   | 404   | 374   | 374   |
| 10                | 806   | 426   | 356   | 316   |
| 11                | 830   | 330   | 292   | 292   |
| 12                | 618   | 372   | 310   | 310   |
| 13                | 600   | 328   | 310   | 298   |
| 14                | 554   | 306   | 294   | 294   |
| 15                | 538   | 310   | 288   | 274   |
| 16                | 544   | 292   | 264   | 238   |
| 17                | 426   | 286   | 286   | 244   |
| 18                | 470   | 280   | 264   | 232   |
| 19                | 466   | 274   | 270   | 218   |
| 20                | 396   | 288   | 242   | 242   |
| 21                | 596   | 242   | 190   | 190   |
| 22                | 508   | 300   | 266   | 226   |
| 23                | 390   | 218   | 218   | 210   |
| 24                | 376   | 210   | 210   | 188   |
| 25                | 452   | 264   | 236   | 204   |
| 26                | 392   | 252   | 200   | 184   |
| 27                | 374   | 256   | 234   | 182   |
| 28                | 404   | 246   | 234   | 174   |
| 29                | 402   | 208   | 192   | 188   |
| 30                | 414   | 252   | 230   | 160   |
| 31                | 614   | 614   | 614   | 614   |

Slots: 30

| shifts/iterations | 8     | 128   | 1024  | 8196  |   
|-------------------|-------|-------|-------|-------|   
| 1                 | 39518 | 22132 | 18052 | 18052 |   
| 2                 | 14648 | 2202  | 2202  | 2202  |   
| 3                 | 5350  | 984   | 984   | 984   |   
| 4                 | 2414  | 274   | 274   | 274   |   
| 5                 | 1464  | 576   | 576   | 576   |   
| 6                 | 1196  | 496   | 496   | 496   |   
| 7                 | 1232  | 528   | 528   | 528   |
| 8                 | 1106  | 254   | 252   | 252   |
| 9                 | 1084  | 262   | 262   | 262   |
| 10                | 884   | 434   | 434   | 434   |
| 11                | 772   | 414   | 360   | 342   |
| 12                | 730   | 322   | 322   | 322   |
| 13                | 854   | 410   | 368   | 368   |
| 14                | 900   | 200   | 198   | 198   |
| 15                | 762   | 494   | 494   | 494   |
| 16                | 520   | 184   | 184   | 184   |
| 17                | 450   | 334   | 298   | 298   |
| 18                | 512   | 336   | 336   | 336   |
| 19                | 614   | 308   | 244   | 244   |
| 20                | 722   | 410   | 410   | 410   |
| 21                | 468   | 176   | 176   | 176   |
| 22                | 494   | 190   | 190   | 190   |
| 23                | 568   | 276   | 270   | 244   |
| 24                | 502   | 268   | 268   | 268   |
| 25                | 472   | 202   | 202   | 202   |
| 26                | 782   | 174   | 156   | 156   |
| 27                | 408   | 178   | 178   | 178   |
| 28                | 580   | 150   | 138   | 126   |
| 29                | 570   | 264   | 248   | 208   |
| 30                | 806   | 806   | 806   | 806   |

Slots: 29

| shifts/iterations | 8     | 128   | 1024  | 8196  |
|-------------------|-------|-------|-------|-------|
| 1                 | 39518 | 22156 | 18116 | 18116 |
| 2                 | 14648 | 1046  | 1010  | 1010  |
| 3                 | 5350  | 774   | 774   | 774   |
| 4                 | 2598  | 814   | 814   | 814   |
| 5                 | 1686  | 638   | 638   | 638   |
| 6                 | 1402  | 608   | 608   | 608   |
| 7                 | 1270  | 550   | 526   | 526   |
| 8                 | 1148  | 574   | 500   | 482   |
| 9                 | 1156  | 538   | 538   | 538   |
| 10                | 1000  | 502   | 460   | 428   |
| 11                | 962   | 444   | 426   | 376   |
| 12                | 846   | 394   | 384   | 356   |
| 13                | 904   | 458   | 374   | 374   |
| 14                | 876   | 428   | 360   | 338   |
| 15                | 842   | 382   | 310   | 310   |
| 16                | 584   | 426   | 354   | 308   |
| 17                | 646   | 398   | 348   | 292   |
| 18                | 688   | 362   | 318   | 280   |
| 19                | 636   | 392   | 320   | 282   |
| 20                | 780   | 378   | 288   | 270   |
| 21                | 694   | 376   | 304   | 272   |
| 22                | 694   | 346   | 294   | 272   |
| 23                | 642   | 344   | 266   | 266   |
| 24                | 678   | 360   | 294   | 260   |
| 25                | 604   | 362   | 274   | 268   |
| 26                | 720   | 304   | 272   | 266   |
| 27                | 632   | 324   | 278   | 258   |
| 28                | 672   | 314   | 272   | 262   |
| 29                | 1078  | 1078  | 1078  | 1078  |

### Observations

The larger the iterations, more chances to make min clashes smaller.
Interestingly, sometimes, on large dataset minimum values are obtained with a shift which is not coprime with slot numbers.


# Manual testing results. Hopfield update observations

With current manual testing, min clashes are increasing after update.
Currently, after update we choose the slot to set 1 randomly. Maybe other strategies will perform better.
Training was done on "good" timeslots: timeslots, which have min clashes of 0.
Maybe, this is a problem. Maybe, these timeslots are not good, because in that particular set up, they "force"
other timeslots to have clashes. Maybe, we should avoid training on these timeslots, and train on more uniformly
distributed states.

In the future, have plans to implement progressive testing.
The idea is to start basic testing. Whenever the min is not changed long enough, we should do update once, for example,
then continue testing, possibly changing shift also. After the min is not changed again, we should do update twice. 
This way, the longer we have no results, the more we are ready to alter the state of the system.

# Automatic testing (Magic button) 

This button does the progressive testing. Does some number of iterations, and if the min is not changed
does several updates based on Hopfield network. The number of updates increases progressively.
The network was trained on "good" slots. With this implementation, leaving overnight, I was able to reach state with 
106 clashes for file "car-f-92.stu" with 30 slots. 

For the file ute-s-92.stu with 9 slots were able to find state with 2 clashes.
For the file car-f-92.stu with 28 slots the algorithm was able to find state with 190 clashes, which is great result.
As a proof for this last statement I can send the log file via email, where the steps the algorithm took are visible.
It is over 100MB, could not push to Github.
