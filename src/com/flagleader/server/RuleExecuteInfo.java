package com.flagleader.server;

import com.flagleader.engine.IRuleContext;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.repository.d.u;
import com.flagleader.repository.f;
import com.flagleader.repository.tree.AdvancedProperty;
import com.flagleader.util.EngineLogger;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.TempID;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RuleExecuteInfo
  implements f
{
  private String exeRuleName;
  private String displayName;
  private int planType = 0;
  private long internalTime = 0L;
  private String specialDay = "";
  private String specialTime = "";
  private boolean runOnce = false;
  private long startTime = 0L;
  private long lastTime = 0L;
  private int state = 3;
  public static final int INITIAL = 0;
  public static final int RUN = 1;
  public static final int WAIT = 2;
  public static final int STOPED = 3;
  private boolean stoped = true;
  private String errorInfo = "";
  private long times = 0L;
  private int tracelogtype = 0;
  private long maxexecutetime = 0L;
  private long executetime = 0L;
  private m exeThread;
  private g viewer;
  private String uuid = null;
  private List advanceProperties = new Vector();

  public String getUuid()
  {
    if ((this.uuid == null) || (this.uuid.length() == 0))
      this.uuid = TempID.newShortTempID();
    return this.uuid;
  }

  private void a()
  {
    if (this.viewer != null)
      this.viewer.a(this);
  }

  public String getExeRuleName()
  {
    return this.exeRuleName;
  }

  public void setExeRuleName(String paramString)
  {
    this.exeRuleName = paramString;
  }

  public String getDisplayName()
  {
    return this.displayName;
  }

  public void setDisplayName(String paramString)
  {
    this.displayName = paramString;
  }

  public String getPlanInfo()
  {
    switch (this.planType)
    {
    case 0:
      return u.a("millisInfo.RuleExecuteInfo", new String[] { String.valueOf(this.internalTime) });
    case 1:
      return u.a("secondsInfo.RuleExecuteInfo", new String[] { String.valueOf(this.internalTime) });
    case 2:
      return u.a("hoursInfo.RuleExecuteInfo", new String[] { String.valueOf(this.internalTime), this.specialTime });
    case 3:
      return u.a("daysInfo.RuleExecuteInfo", new String[] { String.valueOf(this.internalTime), this.specialTime });
    case 4:
      return u.a("weeksInfo.RuleExecuteInfo", new String[] { String.valueOf(this.internalTime), this.specialDay, this.specialTime });
    case 5:
      return u.a("monthsInfo.RuleExecuteInfo", new String[] { String.valueOf(this.internalTime), this.specialDay, this.specialTime });
    case 6:
      if ((this.specialDay.length() > 0) && (this.specialTime.length() > 0))
        return u.a("datetimeOneInfo.RuleExecuteInfo", new String[] { this.specialDay, this.specialTime });
      return u.a("afterOneInfo.RuleExecuteInfo", new String[] { String.valueOf(this.internalTime) });
    }
    return "";
  }

  public long getInternalTime()
  {
    return this.internalTime;
  }

  public void setInternalTime(long paramLong)
  {
    this.internalTime = paramLong;
  }

  public long getStartTime()
  {
    return this.startTime;
  }

  public void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }

  public long getLastTime()
  {
    return this.lastTime;
  }

  public void setLastTime(long paramLong)
  {
    this.lastTime = paramLong;
  }

  public String getStopInfo()
  {
    if ((this.stoped) && (!this.runOnce))
      return u.a("notstart.RuleExecuteInfo");
    return u.a("hasstart.RuleExecuteInfo");
  }

  public int getState()
  {
    return this.state;
  }

  public String getStateInfo()
  {
    switch (this.state)
    {
    case 0:
      return u.a("initial.RuleExecuteInfo");
    case 1:
      return u.a("running.RuleExecuteInfo");
    case 2:
      return u.a("waiting.RuleExecuteInfo");
    }
    return u.a("stoped.RuleExecuteInfo");
  }

  public void setState(int paramInt)
  {
    this.state = paramInt;
  }

  public boolean isStoped()
  {
    return this.stoped;
  }

  public void setStoped(boolean paramBoolean)
  {
    this.stoped = paramBoolean;
    this.maxexecutetime = 0L;
    if ((!paramBoolean) && ((this.exeThread == null) || (this.exeThread.a()) || (!this.exeThread.isAlive())))
    {
      this.state = 0;
      this.exeThread = new m(this, Thread.currentThread());
      this.exeThread.start();
      a();
    }
  }

  public String getErrorInfo()
  {
    return this.errorInfo;
  }

  public void setErrorInfo(String paramString)
  {
    this.errorInfo = paramString;
  }

  public m getExeThread()
  {
    return this.exeThread;
  }

  public void addAdvanceProperty(AdvancedProperty paramAdvancedProperty)
  {
    this.advanceProperties.add(paramAdvancedProperty);
  }

  public List getPropertiesList()
  {
    ArrayList localArrayList = new ArrayList(this.advanceProperties.size());
    localArrayList.addAll(this.advanceProperties);
    return localArrayList;
  }

  public List getAdvanceProperties()
  {
    return this.advanceProperties;
  }

  public List getAllProperties()
  {
    ArrayList localArrayList = new ArrayList(this.advanceProperties.size());
    localArrayList.addAll(this.advanceProperties);
    try
    {
      IRuleContext localIRuleContext = RuleEngineFactory.newInstance().getContext(this.exeRuleName);
      if (localIRuleContext != null)
      {
        String[] arrayOfString = localIRuleContext.getInputs();
        for (int i = 0; i < arrayOfString.length; i++)
        {
          int j = 0;
          for (int k = 0; k < this.advanceProperties.size(); k++)
          {
            if (!((AdvancedProperty)this.advanceProperties.get(k)).getKey().equals(arrayOfString[i]))
              continue;
            j = 1;
            break;
          }
          if (j != 0)
            continue;
          localArrayList.add(new AdvancedProperty(arrayOfString[i], ""));
        }
      }
    }
    catch (Exception localException)
    {
    }
    return localArrayList;
  }

  public void setAdvanceProperties(List paramList)
  {
    this.advanceProperties = paramList;
  }

  public int getPlanType()
  {
    return this.planType;
  }

  public void setPlanType(int paramInt)
  {
    this.planType = paramInt;
  }

  public String getSpecialDay()
  {
    return this.specialDay;
  }

  public void setSpecialDay(String paramString)
  {
    this.specialDay = paramString;
  }

  public String getSpecialTime()
  {
    return this.specialTime;
  }

  public void setSpecialTime(String paramString)
  {
    this.specialTime = paramString;
  }

  public boolean isRunOnce()
  {
    return this.runOnce;
  }

  public void setRunOnce(boolean paramBoolean)
  {
    this.runOnce = paramBoolean;
    if ((paramBoolean) && ((this.exeThread == null) || (this.exeThread.a()) || (!this.exeThread.isAlive())))
    {
      this.exeThread = new m(this, Thread.currentThread());
      this.exeThread.start();
      a();
    }
  }

  public void setViewer(g paramg)
  {
    this.viewer = paramg;
  }

  public String getSuccessInfo()
  {
    if (this.executetime > 0L)
      return u.a("executetimes.RuleExecuteInfo", new String[] { NumberUtil.formatDouble(this.executetime / 1000000.0D, "0.00"), String.valueOf(this.times) });
    return u.a("executetimes2.RuleExecuteInfo", new String[] { String.valueOf(this.times) });
  }

  public long getTimes()
  {
    return this.times;
  }

  public void setTimes(long paramLong)
  {
    this.times = paramLong;
  }

  public int getTracelogtype()
  {
    return this.tracelogtype;
  }

  public void setTracelogtype(int paramInt)
  {
    this.tracelogtype = paramInt;
  }

  public void forceStop()
  {
    this.stoped = true;
    if (this.exeThread != null)
    {
      try
      {
        this.exeThread.stop();
      }
      catch (Throwable localThrowable)
      {
        EngineLogger.getSqlLogger().error("stop thread" + getDisplayName() + localThrowable.getMessage(), localThrowable);
      }
      this.exeThread = null;
      this.state = 3;
      a();
    }
  }

  public boolean isExceedTime()
  {
    return (this.planType == 0) && (this.maxexecutetime > 0L) && (!isStoped()) && (System.currentTimeMillis() - this.startTime > this.maxexecutetime + this.internalTime * 10L);
  }

  public String getParamInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    for (int i = 0; i < this.advanceProperties.size(); i++)
    {
      if (i > 0)
        localStringBuilder.append(",");
      AdvancedProperty localAdvancedProperty = (AdvancedProperty)this.advanceProperties.get(i);
      localStringBuilder.append("\"").append(localAdvancedProperty.getKey()).append("\":\"").append(localAdvancedProperty.getProperty()).append("\"");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }

  public String getFormatedParamInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    for (int i = 0; i < this.advanceProperties.size(); i++)
    {
      if (i > 0)
        localStringBuilder.append(",");
      AdvancedProperty localAdvancedProperty = (AdvancedProperty)this.advanceProperties.get(i);
      localStringBuilder.append("").append(localAdvancedProperty.getKey()).append(":").append(localAdvancedProperty.getProperty()).append("");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }

  public long getMaxexecutetime()
  {
    return this.maxexecutetime;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.server.RuleExecuteInfo
 * JD-Core Version:    0.6.0
 */