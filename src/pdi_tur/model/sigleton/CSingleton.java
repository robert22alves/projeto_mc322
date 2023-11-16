package biblioteca.models.singleton;

abstract public class CSingleton{

static private CSingleton instance = null;

abstract private CSingleton();

public static CSingleton(){
    if(instance == null)
        instance = new CSingleton();
    return instance;
}
}