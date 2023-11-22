package pdi_tur.model.singleton;

abstract public class CSingleton{

static private CSingleton instance = null;

private CSingleton() {}

public static CSingleton criar() {
    if(instance == null)
        instance = new CSingleton() {};
    return instance;
}
}