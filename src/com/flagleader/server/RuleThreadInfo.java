package com.flagleader.server;

import com.flagleader.db.DBFactory;
import com.flagleader.db.Database;
import com.flagleader.repository.d.u;
import com.flagleader.repository.f;
import com.flagleader.util.StringUtil;
import com.flagleader.util.TempID;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

public class RuleThreadInfo
  implements f
{
  private String groupName = "";
  private String displayName = "";
  private String ruleName = "";
  private long internalTime = 10L;
  private long minThreads = 1L;
  private long maxThreads = 10L;
  private int location = 0;
  public static final int LOCALRUN = 0;
  public static final int REMOTERUN = 1;
  public static final int BUFFERRUN = 2;
  private String remoteips = "";
  private String remoteports = "";
  private int remoteloc = 0;
  private String[] ips;
  private int[] ports;
  public static final int RUN = 1;
  public static final int WAIT = 0;
  public static final int STOPED = 2;
  private boolean stoped = false;
  private String connName = "";
  private String sql = "";
  private String errorInfo = "";
  private Vector exeThread = new Vector();
  private Stack receives = new Stack();
  private String uuid = null;

  public String getUuid()
  {
    if ((this.uuid == null) || (this.uuid.length() == 0))
      this.uuid = TempID.newShortTempID();
    return this.uuid;
  }

  public synchronized void appendReceive(k paramk)
  {
    this.receives.push(paramk);
    if (RuleThreadServer.f != null)
      RuleThreadServer.f.a(paramk);
    p localp2;
    for (int i = 0; i < this.exeThread.size(); i++)
    {
      localp2 = (p)this.exeThread.get(i);
      if (localp2.a() == 0)
        return;
    }
    if ((this.minThreads > 0L) && (this.exeThread.size() == 0))
    {
      for (i = 0; i < this.minThreads; i++)
      {
        localp2 = new p(this);
        this.exeThread.add(localp2);
        localp2.start();
      }
      return;
    }
    if ((this.exeThread.size() < this.maxThreads) || (this.maxThreads == 0L))
    {
      p localp1 = new p(this);
      this.exeThread.add(localp1);
      localp1.start();
    }
  }

  public void insertSql(HashMap paramHashMap, String paramString1, String paramString2)
  {
    if ((this.connName != null) && (this.connName.length() > 0))
    {
      Database localDatabase = DBFactory.newIntance().getDatabase(this.connName);
      Iterator localIterator = paramHashMap.keySet().iterator();
      String str2;
      for (String str1 = this.sql; localIterator.hasNext(); str1 = StringUtil.replaceAll(str1, "{" + str2 + "}", StringUtil.replaceAll(String.valueOf(paramHashMap.get(str2)), "'", "''")))
        str2 = String.valueOf(localIterator.next());
      str1 = StringUtil.replaceAll(str1, "{rulename}", StringUtil.replaceAll(paramString1, "'", "''"));
      str1 = StringUtil.replaceAll(str1, "{errorinfo}", StringUtil.replaceAll(paramString2, "'", "''"));
      if (str1.indexOf("?") > 0)
        localDatabase.execute(str1, new Object[] { paramString2 });
      else
        localDatabase.execute(str1);
      localDatabase.freeConnection();
    }
  }

  public String getGroupName()
  {
    if ((this.groupName == null) || (this.groupName.length() == 0))
      return getRuleName();
    return this.groupName;
  }

  public void setGroupName(String paramString)
  {
    this.groupName = paramString;
  }

  public String getDisplayName()
  {
    if ((this.displayName == null) || (this.displayName.length() == 0))
      return getRuleName();
    return this.displayName;
  }

  public void setDisplayName(String paramString)
  {
    this.displayName = paramString;
  }

  public long getInternalTime()
  {
    return this.internalTime;
  }

  public void setInternalTime(long paramLong)
  {
    this.internalTime = paramLong;
  }

  public long getMinThreads()
  {
    return this.minThreads;
  }

  public void setMinThreads(long paramLong)
  {
    this.minThreads = paramLong;
  }

  public long getMaxThreads()
  {
    return this.maxThreads;
  }

  public void setMaxThreads(long paramLong)
  {
    this.maxThreads = paramLong;
  }

  public String getStopInfo()
  {
    if (this.stoped)
      return u.a("notstart.RuleExecuteInfo");
    return u.a("hasstart.RuleExecuteInfo");
  }

  public int getLocation()
  {
    return this.location;
  }

  public void setLocation(int paramInt)
  {
    this.location = paramInt;
  }

  public boolean isStoped()
  {
    return this.stoped;
  }

  public void setStoped(boolean paramBoolean)
  {
    this.stoped = paramBoolean;
  }

  public String getErrorInfo()
  {
    return this.errorInfo;
  }

  public void setErrorInfo(String paramString)
  {
    this.errorInfo = paramString;
  }

  public Stack getReceives()
  {
    return this.receives;
  }

  public void setReceives(Stack paramStack)
  {
    this.receives = paramStack;
  }

  public String getRuleName()
  {
    return this.ruleName;
  }

  public void setRuleName(String paramString)
  {
    this.ruleName = paramString;
  }

  public String getRemoteips()
  {
    return this.remoteips;
  }

  public void setRemoteips(String paramString)
  {
    this.remoteips = paramString;
    this.ips = paramString.split(";");
  }

  public String getRemoteports()
  {
    return this.remoteports;
  }

  public void setRemoteports(String paramString)
  {
    this.remoteports = paramString;
    String[] arrayOfString = paramString.split(";");
    int i;
    if ((this.ips != null) && ((arrayOfString == null) || (arrayOfString.length == 0)))
    {
      this.ports = new int[this.ips.length];
      for (i = 0; i < this.ips.length; i++)
        this.ports[i] = ServerProperty.a().f();
    }
    else if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      this.ports = new int[arrayOfString.length];
      for (i = 0; i < arrayOfString.length; i++)
        if (arrayOfString[i].length() > 0)
          this.ports[i] = Integer.parseInt(arrayOfString[i]);
        else
          this.ports[i] = ServerProperty.a().f();
    }
  }

  public String getConnName()
  {
    return this.connName;
  }

  public void setConnName(String paramString)
  {
    this.connName = paramString;
  }

  public String getSql()
  {
    return this.sql;
  }

  public void setSql(String paramString)
  {
    this.sql = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.server.RuleThreadInfo
 * JD-Core Version:    0.6.0
 */