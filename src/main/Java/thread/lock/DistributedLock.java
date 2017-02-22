package thread.lock;

import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by zzqno on 2016-9-27.
 */
public abstract class DistributedLock extends RemoteObject {

    public long lock() throws  RemoteException, TimeoutException{

        return 0;
    }

    public long tryLock(long time, TimeUnit unit) throws RemoteException, TimeoutException{
        return 0;
    }

   public void unlock(long token) throws RemoteException{}
}
