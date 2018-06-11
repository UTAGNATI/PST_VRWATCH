import pantilthat
import math

while True:
    poub = raw_input()
    donnees = raw_input()
    
    ##
    
    #print(donnees)
    cd = 0

    if donnees[24] == '-':cd+=1
    if donnees[37+cd] == '-':cd+=1
    if donnees[50+cd] == '-':cd+=1

    qw = float(donnees[64+cd:70+cd])
    if donnees[64+cd] == '-':cd+=1
    qx = float(donnees[78+cd:84+cd])
    if donnees[78+cd] == '-':cd+=1
    qy = float(donnees[92+cd:98+cd])
    if donnees[92+cd] == '-':cd+=1
    qz = float(donnees[106+cd:112+cd])


    def quaternion_to_euler_angle(w, x, y, z):
            ysqr = y * y
            
            t0 = +2.0 * (w * x + y * z)
            t1 = +1.0 - 2.0 * (x * x + ysqr)
            X = math.degrees(math.atan2(t0, t1))
            
            t2 = +2.0 * (w * y - z * x)
            t2 = +1.0 if t2 > +1.0 else t2
            t2 = -1.0 if t2 < -1.0 else t2
            Y = math.degrees(math.asin(t2))
            
            t3 = +2.0 * (w * z + x * y)
            t4 = +1.0 - 2.0 * (ysqr + z * z)
            Z = math.degrees(math.atan2(t3, t4))
            
            return X, Y, Z
    
    x,y,z = quaternion_to_euler_angle(qw, qx, qy, qz)
    
    i=0
    while i<2:
        if -90<x<90:
            pantilthat.tilt(-x)
    
        if -90<y<90:
            pantilthat.pan(y)
    
        i=i+1
    

    ##
