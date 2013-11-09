package com.flagleader.repository.f;

import com.flagleader.repository.e.f;
import com.flagleader.repository.tree.GroupInfo;
import com.flagleader.repository.tree.PackageInfo;
import com.flagleader.repository.tree.ProjectInfo;
import com.flagleader.repository.tree.al;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.map.CaseInsensitiveMap;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class n
  implements b, c
{
  private static n a = new n();
  private List b = new ArrayList();
  private List c = new ArrayList();
  private List d = new ArrayList();
  private String e = null;
  private Map f = new CaseInsensitiveMap();

  public Map b()
  {
    return this.f;
  }

  public String c()
  {
    return this.e;
  }

  public void a(String paramString)
  {
    this.e = paramString;
  }

  private void b(al paramal)
  {
    this.f.put(paramal.getUuid(), paramal);
    List localList = paramal.getPackageInfos();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof GroupInfo))
      {
        b((GroupInfo)localList.get(i));
      }
      else
      {
        if (!(localList.get(i) instanceof PackageInfo))
          continue;
        this.f.put(((PackageInfo)localList.get(i)).getUuid(), (PackageInfo)localList.get(i));
      }
  }

  public void a(al paramal)
  {
    this.f.put(paramal.getUuid(), paramal);
  }

  public void a(PackageInfo paramPackageInfo)
  {
    this.f.put(paramPackageInfo.getUuid(), paramPackageInfo);
  }

  public void b(String paramString)
  {
    this.f.remove(paramString);
  }

  public Object c(String paramString)
  {
    return this.f.get(paramString);
  }

  public void a()
  {
    if (this.b != null)
      this.b.clear();
    if (this.c != null)
      this.c.clear();
    if (this.e != null)
    {
      File localFile1 = new File(this.e);
      File[] arrayOfFile = localFile1.listFiles();
      Object localObject1;
      Object localObject3;
      Object localObject4;
      Object localObject2;
      for (int i = 0; i < arrayOfFile.length; i++)
      {
        localObject1 = new File(arrayOfFile[i], "default.prj");
        if (((File)localObject1).exists())
        {
          try
          {
            ProjectInfo localProjectInfo = (ProjectInfo)new f().load((File)localObject1);
            this.f.put(localProjectInfo.getUuid(), localProjectInfo);
            localObject3 = localProjectInfo.getPackageInfos();
            for (int j = 0; j < ((List)localObject3).size(); j++)
              if ((((List)localObject3).get(j) instanceof GroupInfo))
              {
                b((GroupInfo)((List)localObject3).get(j));
              }
              else
              {
                if (!(((List)localObject3).get(j) instanceof PackageInfo))
                  continue;
                this.f.put(((PackageInfo)((List)localObject3).get(j)).getUuid(), (PackageInfo)((List)localObject3).get(j));
              }
            localObject4 = new k(arrayOfFile[i].getPath(), localProjectInfo);
            this.b.add(localObject4);
            ((k)localObject4).g();
            b(localProjectInfo);
          }
          catch (Exception localException)
          {
          }
        }
        else
        {
          if (!arrayOfFile[i].isDirectory())
            continue;
          localObject2 = new ProjectInfo();
          ((ProjectInfo)localObject2).setDisplayName(arrayOfFile[i].getName());
          localObject3 = new k(arrayOfFile[i].getPath(), (ProjectInfo)localObject2);
          this.b.add(localObject3);
          ((k)localObject3).g();
          b((al)localObject2);
        }
      }
      File localFile2 = new File(this.e, "user.xml");
      int k;
      Element localElement;
      Object localObject5;
      if ((localFile2 != null) && (localFile2.exists()))
        try
        {
          localObject1 = new SAXBuilder();
          localObject2 = ((SAXBuilder)localObject1).build(localFile2);
          localObject3 = ((Document)localObject2).getRootElement();
          localObject4 = ((Element)localObject3).getChildren("user");
          for (k = 0; k < ((List)localObject4).size(); k++)
          {
            localElement = (Element)((List)localObject4).get(k);
            localObject5 = new o(localElement.getAttributeValue("username"), localElement.getAttributeValue("password"));
            if (localElement.getAttribute("roletype") != null)
              ((o)localObject5).a(NumberUtil.parseInt(localElement.getAttributeValue("roletype")));
            this.c.add(localObject5);
            if (((o)localObject5).i())
            {
              for (int m = 0; m < this.b.size(); m++)
                ((o)localObject5).c(((k)this.b.get(m)).f());
            }
            else
            {
              List localList = localElement.getChildren("project");
              for (int n = 0; n < localList.size(); n++)
                ((o)localObject5).c(((Element)localList.get(n)).getAttributeValue("name"));
            }
          }
        }
        catch (JDOMException localJDOMException1)
        {
          localJDOMException1.printStackTrace();
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
        }
      localFile2 = new File(this.e, "deploy.xml");
      if ((localFile2 != null) && (localFile2.exists()))
        try
        {
          SAXBuilder localSAXBuilder = new SAXBuilder();
          localObject2 = localSAXBuilder.build(localFile2);
          localObject3 = ((Document)localObject2).getRootElement();
          localObject4 = ((Element)localObject3).getChildren("target");
          for (k = 0; k < ((List)localObject4).size(); k++)
          {
            localElement = (Element)((List)localObject4).get(k);
            localObject5 = new j(localElement.getAttributeValue("location"), localElement.getChildText("rootpath"));
            if (localElement.getAttribute("ftpPassword") != null)
              ((j)localObject5).e(localElement.getAttributeValue("ftpPassword"));
            if (localElement.getAttribute("ftpUser") != null)
              ((j)localObject5).c(localElement.getAttributeValue("ftpUser"));
            if (localElement.getAttribute("ftpServer") != null)
              ((j)localObject5).d(localElement.getAttributeValue("ftpServer"));
            if (localElement.getAttribute("ftpPort") != null)
              ((j)localObject5).f(localElement.getAttributeValue("ftpPort"));
            if (localElement.getAttribute("ftpType") != null)
              ((j)localObject5).g(localElement.getAttributeValue("ftpType"));
            this.d.add(localObject5);
          }
        }
        catch (JDOMException localJDOMException2)
        {
          localJDOMException2.printStackTrace();
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
        }
    }
  }

  private Element g()
  {
    Element localElement1 = new Element("root");
    for (int i = 0; i < this.c.size(); i++)
    {
      o localo = (o)this.c.get(i);
      Element localElement2 = new Element("user");
      localElement2.setAttribute("username", localo.a());
      localElement2.setAttribute("password", localo.c());
      List localList = localo.j();
      for (int j = 0; j < localList.size(); j++)
      {
        Element localElement3 = new Element("project");
        localElement3.setAttribute("name", localList.get(j).toString());
        localElement2.addContent(localElement3);
      }
      localElement1.addContent(localElement2);
    }
    return localElement1;
  }

  public synchronized void d()
  {
    File localFile = new File(this.e, "user.xml");
    Document localDocument = null;
    if (localDocument == null)
      localDocument = new Document(g());
    if (!localFile.getParentFile().exists())
      localFile.getParentFile().mkdirs();
    XMLOutputter localXMLOutputter = null;
    localXMLOutputter = new XMLOutputter(Format.getRawFormat().setEncoding("UTF-8"));
    FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
    localXMLOutputter.output(localDocument, localFileOutputStream);
    localFileOutputStream.close();
  }

  public static n e()
  {
    return a;
  }

  public o a(String paramString1, String paramString2)
  {
    for (int i = 0; i < this.c.size(); i++)
    {
      o localo = (o)this.c.get(i);
      if ((localo.a().equalsIgnoreCase(paramString1)) && (localo.c().equals(paramString2)))
        return localo;
    }
    return null;
  }

  public void a(p paramp)
  {
    this.b.add(paramp);
  }

  public List d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    o localo = f(paramString);
    if (localo != null)
    {
      List localList = localo.j();
      for (int i = 0; i < localList.size(); i++)
      {
        String str = (String)localList.get(i);
        for (int j = 0; j < this.b.size(); j++)
        {
          k localk = (k)this.b.get(j);
          if (!localk.f().equalsIgnoreCase(str))
            continue;
          localArrayList.add(localk);
        }
      }
    }
    return localArrayList;
  }

  public List f()
  {
    return this.b;
  }

  public boolean e(String paramString)
  {
    for (int i = 0; i < this.b.size(); i++)
    {
      k localk = (k)this.b.get(i);
      if (localk.f().equalsIgnoreCase(paramString))
        return true;
    }
    return false;
  }

  public o f(String paramString)
  {
    for (int i = 0; i < this.c.size(); i++)
    {
      o localo = (o)this.c.get(i);
      if (localo.a().equalsIgnoreCase(paramString))
        return localo;
    }
    return null;
  }

  public String a(File paramFile, String paramString)
  {
    for (int i = 0; i < this.d.size(); i++)
    {
      j localj = (j)this.d.get(i);
      if (localj.a())
      {
        try
        {
          FileUtil.copy(paramFile, new File(localj.d(), paramString.replace('.', '/') + ".rsc"), true);
        }
        catch (Exception localException)
        {
          return "error:" + localException.getMessage();
        }
      }
      else
      {
        if (!localj.b())
          continue;
        String str = localj.a(paramFile, paramString);
        if (!StringUtil.isEmpty(str))
          return str;
      }
    }
    return "";
  }

  public List g(String paramString)
  {
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.f.n
 * JD-Core Version:    0.6.0
 */