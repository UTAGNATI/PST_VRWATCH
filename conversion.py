import pantilthat
import math

while True:
    poub = raw_input()
    donnees = raw_input()
    ##
    if donnees[14]== "H":
        cd = 0

        if donnees[23] == '-':cd+=1
        if donnees[37] == '-':cd+=1
        if donnees[50] == '-':cd+=1

        qw = float(donnees[63+cd:70+cd])
        if donnees[63+cd] == '-':cd+=1
        qx = float(donnees[77+cd:84+cd])
        if donnees[77+cd] == '-':cd+=1
        qy = float(donnees[91+cd:98+cd])
        if donnees[93+cd] == '-':cd+=1
        qz = float(donnees[106+cd:113+cd])


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
        while i<10:
            if -90<x<90:
                pantilthat.tilt(-x)
        
            if -90<y<90:
                pantilthat.pan(-y)
        
            print(x,y)
            i=i+1
        

    ##
