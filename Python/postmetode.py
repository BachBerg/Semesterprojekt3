# -*- coding: utf-8 -*-
"""
Created on Tue Jan 11 10:41:48 2022

@author: Andreas
"""

import requests
import json
  
# OBBBBSSSSS     Tomcat Serveren skal PT være tændt.

endpoint = "http://localhost:8080/Semesterprojekt3_war/data/ekgSessions"


cpr= "1234567890" #CPR
dsparray = [1,2,3,4,5,6,7,8,9,23,32,41,252,3,562,34,421,3,0] #Dsp plot array
Headers={'Authorization': 'Bearer hemmeliglogin', #Loginkode
         'Identifier': cpr} 

  
# Post request, med endpoint, dataen og headers til genkendelse og sikkerhed.
r = requests.post(endpoint,  data = json.dumps(dsparray), headers = Headers )
  
#Modtage responbesked 
Response = r.text
print(Response)


