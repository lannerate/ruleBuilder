package com.flagleader.repository.f;

import com.flagleader.engine.RuleEngine;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.repository.tree.GroupInfo;
import com.flagleader.repository.tree.PackageInfo;
import com.flagleader.repository.tree.ProjectInfo;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.al;
import com.flagleader.util.DateUtil;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.map.CaseInsensitiveMap;

public class h
  implements b, c
{
  private static h a = new h();
  private List b = new ArrayList();
  private Map c = new CaseInsensitiveMap();
  private List d = new ArrayList();

  public Map b()
  {
    return this.c;
  }

  private void b(al paramal)
  {
    this.c.put(paramal.getUuid(), paramal);
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
        this.c.put(((PackageInfo)localList.get(i)).getUuid(), (PackageInfo)localList.get(i));
      }
  }

  public void a(al paramal)
  {
    this.c.put(paramal.getUuid(), paramal);
  }

  public void a(PackageInfo paramPackageInfo)
  {
    this.c.put(paramPackageInfo.getUuid(), paramPackageInfo);
  }

  public void a(String paramString)
  {
    this.c.remove(paramString);
  }

  public Object b(String paramString)
  {
    return this.c.get(paramString);
  }

  public f a(String paramString1, String paramString2)
  {
    RuleEngine localRuleEngine = RuleEngineFactory.newInstance().getRuleEngine();
    localRuleEngine.put("ruleproject", paramString1);
    localRuleEngine.put("loginname", paramString2);
    localRuleEngine.put("act", "new");
    localRuleEngine.excute("com.flagleader.dbrule.ruleproject");
    String str = localRuleEngine.getString("err");
    if (StringUtil.isEmpty(str))
    {
      localProjectInfo = new ProjectInfo();
      localProjectInfo.setDisplayName(paramString1);
      localf = new f(this, localProjectInfo);
      a(localProjectInfo);
      return localf;
    }
    ProjectInfo localProjectInfo = new ProjectInfo();
    localProjectInfo.setDisplayName(paramString1);
    localProjectInfo.setUuid("proj" + localRuleEngine.getInteger("projid"));
    f localf = new f(this, localProjectInfo);
    a(localProjectInfo);
    return localf;
  }

  public void c(String paramString)
  {
    RuleEngine localRuleEngine = RuleEngineFactory.newInstance().getRuleEngine();
    localRuleEngine.put("projectname", paramString);
    localRuleEngine.put("hideAct", "deleteproject");
    localRuleEngine.excute("com.flagleader.dbrule.allprojects");
  }

  public void a(RulePackage paramRulePackage, i parami)
  {
    RuleEngine localRuleEngine = RuleEngineFactory.newInstance().getRuleEngine();
    localRuleEngine.put("loginedname", parami.a());
    localRuleEngine.put("ruleid", new Integer(paramRulePackage.getRulesid()));
    if (parami.b() > 0)
      localRuleEngine.put("userid", parami.b());
    localRuleEngine.put("exerule", paramRulePackage.getExeRulePackageName());
    localRuleEngine.put("ruledescribe", paramRulePackage.getDocument());
    localRuleEngine.put("ruledisplay", paramRulePackage.getDisplayName());
    localRuleEngine.put("rulecontent", paramRulePackage.getSavedText());
    localRuleEngine.put("rulever", NumberUtil.getDouble(paramRulePackage.getVersion()));
    localRuleEngine.excute("com.flagleader.dbrule.saverule");
  }

  private ProjectInfo g(String paramString)
  {
    for (int i = 0; i < this.b.size(); i++)
    {
      f localf2 = (f)this.b.get(i);
      if (!localf2.d().equalsIgnoreCase(paramString))
        continue;
      ProjectInfo localProjectInfo = localf2.c();
      return localProjectInfo;
    }
    f localf1 = a(paramString, "admin");
    if (localf1 != null)
      return localf1.c();
    return null;
  }

  private GroupInfo c(String paramString1, String paramString2)
  {
    for (int i = 0; i < this.b.size(); i++)
    {
      f localf2 = (f)this.b.get(i);
      if (!localf2.d().equalsIgnoreCase(paramString2))
        continue;
      ProjectInfo localProjectInfo = localf2.c();
      return localProjectInfo.findOrCreate(paramString1);
    }
    f localf1 = a(paramString2, "admin");
    if (localf1 != null)
      return localf1.c().findOrCreate(paramString1);
    return null;
  }

  public void a()
  {
    if (this.b != null)
      this.b.clear();
    RuleEngine localRuleEngine = RuleEngineFactory.newInstance().getRuleEngine();
    localRuleEngine.excute("com.flagleader.dbrule.allprojects");
    List localList1 = localRuleEngine.getListList("projectList");
    List localList2 = localRuleEngine.getListList("groupList");
    List localList3 = localRuleEngine.getListList("ruleList");
    List localList5;
    Object localObject1;
    Object localObject2;
    for (int i = 0; i < localList1.size(); i++)
    {
      localList5 = (List)localList1.get(i);
      localObject1 = new ProjectInfo();
      ((ProjectInfo)localObject1).setUuid("proj" + String.valueOf(localList5.get(0)));
      ((ProjectInfo)localObject1).setDisplayName(String.valueOf(localList5.get(1)));
      ((ProjectInfo)localObject1).setDocument(String.valueOf(localList5.get(2)));
      this.c.put(((ProjectInfo)localObject1).getUuid(), localObject1);
      localObject2 = new f(this, (ProjectInfo)localObject1);
      this.b.add(localObject2);
      b((al)localObject1);
    }
    Object localObject3;
    for (i = 0; i < localList2.size(); i++)
    {
      localList5 = (List)localList2.get(i);
      localObject1 = String.valueOf(localList5.get(0));
      localObject2 = String.valueOf(localList5.get(1));
      localObject3 = c((String)localObject1, (String)localObject2);
      this.c.put(((GroupInfo)localObject3).getUuid(), localObject3);
    }
    String str1;
    int n;
    Object localObject4;
    for (i = 0; i < localList3.size(); i++)
    {
      localList5 = (List)localList3.get(i);
      int k = NumberUtil.getInt(localList5.get(0));
      localObject2 = StringUtil.stringValue(localList5.get(1));
      localObject3 = StringUtil.stringValue(localList5.get(2));
      str1 = StringUtil.stringValue(localList5.get(3));
      n = NumberUtil.getInt(localList5.get(4));
      localObject4 = StringUtil.stringValue(localList5.get(5));
      Date localDate = DateUtil.getDate(localList5.get(6));
      double d1 = NumberUtil.getDouble(localList5.get(7));
      String str2 = StringUtil.stringValue(localList5.get(8));
      int i1 = NumberUtil.getInt(localList5.get(9));
      PackageInfo localPackageInfo = new PackageInfo();
      localPackageInfo.setDisplayName((String)localObject3);
      localPackageInfo.setExename((String)localObject2);
      localPackageInfo.setFileTime(localDate.getTime());
      localPackageInfo.setRuleEditLevel(i1);
      localPackageInfo.setRuleid(k);
      localPackageInfo.setRulever(d1);
      if (!StringUtil.isEmpty(str2))
      {
        GroupInfo localGroupInfo = c(str2, (String)localObject4);
        localGroupInfo.addPackageInfo(localPackageInfo);
        this.c.put(localGroupInfo.getUuid(), localGroupInfo);
      }
      else
      {
        g((String)localObject4).addPackageInfo(localPackageInfo);
      }
      this.c.put(localPackageInfo.getUuid(), localPackageInfo);
    }
    List localList4 = localRuleEngine.getListList("userList");
    for (int j = 0; j < localList4.size(); j++)
    {
      List localList6 = (List)localList4.get(j);
      int m = NumberUtil.getInt(localList6.get(0));
      localObject3 = StringUtil.stringValue(localList6.get(1));
      str1 = StringUtil.stringValue(localList6.get(2));
      n = NumberUtil.getInt(localList6.get(3));
      localObject4 = f(str1);
      ((i)localObject4).a(n);
      ((i)localObject4).b((String)localObject3);
    }
  }

  public static h c()
  {
    return a;
  }

  public i b(String paramString1, String paramString2)
  {
    RuleEngine localRuleEngine = RuleEngineFactory.newInstance().getRuleEngine();
    localRuleEngine.put("password", paramString2);
    localRuleEngine.put("loginedname", paramString1);
    localRuleEngine.put("act", "new");
    localRuleEngine.excute("com.flagleader.dbrule.loginproject");
    String str = localRuleEngine.getString("err");
    if ((StringUtil.isEmpty(str)) && (localRuleEngine.getListList("projlist").size() > 0))
      return f(paramString1);
    return null;
  }

  public void a(p paramp)
  {
    this.b.add(paramp);
  }

  public List d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    i locali = f(paramString);
    if (locali != null)
    {
      List localList = locali.i();
      for (int i = 0; (localList != null) && (i < localList.size()); i++)
      {
        String str = (String)localList.get(i);
        for (int j = 0; j < this.b.size(); j++)
        {
          f localf = (f)this.b.get(j);
          if (!localf.d().equalsIgnoreCase(str))
            continue;
          localArrayList.add(localf);
        }
      }
    }
    return localArrayList;
  }

  public List d()
  {
    return this.b;
  }

  public boolean e(String paramString)
  {
    for (int i = 0; i < this.b.size(); i++)
    {
      f localf = (f)this.b.get(i);
      if (localf.d().equalsIgnoreCase(paramString))
        return true;
    }
    return false;
  }

  public i f(String paramString)
  {
    if (paramString == null)
      return null;
    for (int i = 0; i < this.d.size(); i++)
    {
      i locali2 = (i)this.d.get(i);
      if (locali2.a().equalsIgnoreCase(paramString))
        return locali2;
    }
    i locali1 = new i();
    locali1.a(paramString);
    this.d.add(locali1);
    return locali1;
  }

  public String a(File paramFile, String paramString1, String paramString2)
  {
    if (!StringUtil.isEmpty(paramString1))
    {
      RuleEngine localRuleEngine = RuleEngineFactory.newInstance().getRuleEngine();
      localRuleEngine.put("exerule", paramString1);
      localRuleEngine.put("ruleproject", paramString2);
      localRuleEngine.put("rsctime", new Date(paramFile.lastModified()));
      localRuleEngine.put("muser", "admin");
      localRuleEngine.put("mtime", new Date());
      localRuleEngine.put("rscfile", FileUtil.readFile(paramFile));
      localRuleEngine.excute("com.flagleader.dbrule.saverscdb");
    }
    return "";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.f.h
 * JD-Core Version:    0.6.0
 */