package com.flagleader.repository.lang.info;

import com.flagleader.a.B;
import com.flagleader.a.F;
import com.flagleader.a.M;
import com.flagleader.a.P;
import com.flagleader.a.T;
import com.flagleader.a.b.g;
import com.flagleader.a.c.n;
import com.flagleader.a.y;
import com.flagleader.engine.Property;
import com.flagleader.repository.AbstractElement;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.util.StringUtil;
import com.flagleader.util.collection.IIterator;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class InfoClass extends AbstractElement
{
  private String className;
  private String version = "1";
  private long lasttime = 0L;
  private String fileName;
  private String versionInfo = "";
  private boolean modified = false;

  public InfoClass()
  {
  }

  public InfoClass(InfoClass paramInfoClass)
  {
    super(paramInfoClass);
    this.className = paramInfoClass.className;
    this.version = paramInfoClass.version;
    this.lasttime = paramInfoClass.lasttime;
    this.versionInfo = paramInfoClass.versionInfo;
  }

  public InfoClass(String paramString)
  {
    super(paramString);
  }

  public String getClassName()
  {
    return this.className;
  }

  public void setClassName(String paramString)
  {
    this.className = paramString;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return null;
  }

  public IElement deepClone()
  {
    return new InfoClass(this);
  }

  public String getName()
  {
    return "InfoClass";
  }

  public String getVersion()
  {
    return this.version;
  }

  public void setVersion(String paramString)
  {
    this.version = paramString;
  }

  public long getLasttime()
  {
    return this.lasttime;
  }

  public void setLasttime(long paramLong)
  {
    this.lasttime = paramLong;
  }

  public void deleteFile()
  {
    File localFile = null;
    if ((this.fileName != null) && (this.fileName.length() > 0))
      localFile = new File(this.fileName);
    if ((localFile != null) && (localFile.exists()))
      localFile.delete();
  }

  public void save()
  {
    File localFile = null;
    if ((this.fileName != null) && (this.fileName.length() > 0))
      localFile = new File(this.fileName);
    if ((this.fileName == null) || (!localFile.isFile()) || (!localFile.exists()))
      if ((getClass().getClassLoader().getResource(this.className + a.b) != null) && (new File(getClass().getClassLoader().getResource(this.className + a.b).getPath()).exists()))
        localFile = new File(getClass().getClassLoader().getResource(this.className + a.b).getPath());
      else if ((getClass().getClassLoader().getResource(this.className + ".jcf") != null) && (new File(getClass().getClassLoader().getResource(this.className + ".jcf").getPath()).exists()))
        localFile = new File(getClass().getClassLoader().getResource(this.className + ".jcf").getPath());
      else if (new File(Property.getInstance().getRuleEngineClassDir()).exists())
        localFile = new File(new File(Property.getInstance().getRuleEngineClassDir()), this.className.replace('.', File.separatorChar) + ".jcf");
      else
        localFile = new File(FileUtil.getCurrentDir(), this.className.replace('.', File.separatorChar) + ".jcf");
    localFile.getParentFile().mkdirs();
    d locald = new d(localFile);
    locald.a(this);
    locald.close();
  }

  public InfoMember getMember(List paramList, M paramM)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      InfoMember localInfoMember = (InfoMember)paramList.get(i);
      String str = localInfoMember.getMemberName();
      if (str.indexOf(", ") > 0)
        str = StringUtil.replace(", ", ",", str);
      if (!str.equals(paramM.I()))
        continue;
      if (((paramM instanceof y)) && ((localInfoMember instanceof InfoAttribute)))
        return localInfoMember;
      if (((paramM instanceof F)) && ((localInfoMember instanceof InfoConstructor)))
        return localInfoMember;
      if (((paramM instanceof P)) && ((localInfoMember instanceof InfoMethod)))
        return localInfoMember;
    }
    return null;
  }

  public InfoMember getMember(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof InfoMember)) && (((InfoMember)localObject).getMemberName().equals(paramString)))
        return (InfoMember)localObject;
    }
    return null;
  }

  public void updateClass(Class paramClass)
  {
    g localg = new g();
    localg.a(paramClass);
    B localB = localg.d(this.className);
    T localT = null;
    localT = n.b(localB.i(), new b(this));
    List localList = getChildrenList();
    clearAllChildren();
    while (localT.hasNext())
    {
      M localM = (M)localT.next();
      Object localObject = getMember(localList, localM);
      if (localObject == null)
        if ((localM instanceof F))
        {
          localObject = new InfoConstructor();
        }
        else if ((localM instanceof P))
        {
          localObject = new InfoMethod();
        }
        else
        {
          if (!(localM instanceof y))
            continue;
          localObject = new InfoAttribute();
        }
      addChildElement((IElement)localObject);
      ((InfoMember)localObject).setMember(localM);
    }
    setModified(true);
  }

  public String getFileName()
  {
    return this.fileName;
  }

  public void addChildElement(IElement paramIElement)
  {
    if ((paramIElement instanceof InfoMember))
      for (int i = 0; i < a().size(); i++)
        if (((a().get(i) instanceof InfoMember)) && (((InfoMember)a().get(i)).getMemberName().equals(((InfoMember)paramIElement).getMemberName())))
          return;
    super.addChildElement(paramIElement);
  }

  public void setFileName(String paramString)
  {
    this.fileName = paramString;
  }

  public String getVersionInfo()
  {
    return this.versionInfo;
  }

  public void setVersionInfo(String paramString)
  {
    this.versionInfo = paramString;
  }

  public boolean isModified()
  {
    return this.modified;
  }

  public void setModified(boolean paramBoolean)
  {
    this.modified = paramBoolean;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.info.InfoClass
 * JD-Core Version:    0.6.0
 */