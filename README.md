# Tcp_Timeout_Calculation

In TCP, a retransmission timer for each segment detects its loss. The timer duration is called retransmission timeout (RTO). Retransmission is the basis of reliability in TCP. Accurate RTO calculation for each TCP connection is critical to performance. 


EstimatedRTT = (1 - alpha)*EstimatedRTT + alpha*SampleRTT

0 < alpha < 1
typical alpha = 0.125

RTO = EstimatedRTT = 4*Deviation
  where
    Deviation = (1 - alpha)*Deviation + alpha*|SampleRTT - EstimatedRTT|
    
The programs used include two java files. SamRTT.java is a class made to hold the values of Alpha, SampleRTT, EstimatedRTT, Deviation, and RTO for the current row during calculation. SorensenMichael_Project_2.java includes the program's main method to print the table and methods to calculate each variable then set them in the class object. 
