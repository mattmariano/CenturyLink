#
build with maven 3.6.3
use JDK 1.8 or greater
to build use : mvn package
to run use: java -jar .\target\CenturyLink-0.0.1-SNAPSHOT-jar-with-dependencies.jar

Output:
id=0, name=grandpa, parent=null, children=[{ id=1, name=son}, { id=2, name=daugther}], siblings=[]
id=1, name=son, parent={ id= 0, name=grandpa}, children=[{ id=3, name=grandkid}, { id=4, name=grandkid}], siblings=[{ id=2, name=daugther }]
id=2, name=daugther, parent={ id= 0, name=grandpa}, children=[{ id=5, name=grandkid}], siblings=[{ id=1, name=son }]
id=3, name=grandkid, parent={ id= 1, name=son}, children=[], siblings=[{ id=4, name=grandkid }]
id=4, name=grandkid, parent={ id= 1, name=son}, children=[], siblings=[{ id=3, name=grandkid }]
id=5, name=grandkid, parent={ id= 2, name=daugther}, children=[{ id=6, name=greatgrandkid}], siblings=[]
id=6, name=greatgrandkid, parent={ id= 5, name=grandkid}, children=[], siblings=[]