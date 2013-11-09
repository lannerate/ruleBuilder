package com.flagleader.manager.a.a;

import com.flagleader.engine.RuleService;
import com.flagleader.manager.builder.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.IElement;
import com.flagleader.repository.e.s;
import com.flagleader.repository.e.t;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.ParentInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class h extends i
{
  public h(r paramr)
  {
    super(paramr);
  }

  public List a(String paramString1, String paramString2)
  {
    RuleService localRuleService = j();
    String str = this.b.b().getUserServer();
    int i = this.b.b().getUserType();
    int j = this.b.b().getUserid();
    if ((str == null) || (j == 0) || (i < 1))
    {
      this.c = c.b("empty.LoginDialog");
      return null;
    }
    localRuleService.put("loginname", str);
    localRuleService.put("userid", j);
    localRuleService.put("exename", paramString1);
    localRuleService.execute(this.a + "nodelist");
    this.c = localRuleService.getString("error");
    if ((this.c != null) && (this.c.length() > 0))
      return null;
    Object localObject = localRuleService.get("ruleList");
    if ((localObject != null) && ((localObject instanceof List)))
      return (List)localRuleService.get("ruleList");
    return new ArrayList(0);
  }

  public ParentInfo a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    RuleService localRuleService = j();
    String str1 = this.b.b().getUserServer();
    int i = this.b.b().getUserType();
    int j = this.b.b().getUserid();
    if ((str1 == null) || (j == 0) || (i < 1))
      return null;
    localRuleService.put("loginname", str1);
    localRuleService.put("exename", paramString1);
    localRuleService.put("parentpath", paramString2);
    localRuleService.put("nodename", paramString3);
    localRuleService.put("nodetype", paramString4);
    localRuleService.execute(this.a + "noderead");
    String str2 = localRuleService.getString("error");
    if ((str2 == null) || (str2.length() == 0))
    {
      String str3 = localRuleService.getString("filecontext");
      ParentInfo localParentInfo = (ParentInfo)new s().load(str3);
      return localParentInfo;
    }
    this.b.b().showError(str2);
    return null;
  }

  private static String b(IElement paramIElement)
  {
    if ((paramIElement instanceof IRulePackage))
      return paramIElement.getDisplayName();
    if ((paramIElement.getParent() instanceof IPackageElement))
      return b((IPackageElement)paramIElement.getParent()) + "/" + paramIElement.getDisplayName();
    return "";
  }

  public static String a(IElement paramIElement)
  {
    if ((paramIElement instanceof IRulePackage))
      return paramIElement.getDisplayName() + "." + paramIElement.getName();
    if ((paramIElement.getParent() instanceof IPackageElement))
      return b((IPackageElement)paramIElement.getParent()) + "/" + paramIElement.getDisplayName() + "." + paramIElement.getName();
    return "";
  }

  private void a(ArrayList paramArrayList, ITreeNode paramITreeNode)
  {
    ArrayList localArrayList = new ArrayList(5);
    localArrayList.add(a(paramITreeNode.getParent()));
    localArrayList.add(paramITreeNode.getDisplayName());
    localArrayList.add(paramITreeNode.getName());
    localArrayList.add(new Integer(paramITreeNode.getPos()));
    localArrayList.add(new Date(paramITreeNode.getModifyTime()));
    localArrayList.add(t.b(paramITreeNode));
    paramArrayList.add(localArrayList);
    Iterator localIterator = paramITreeNode.getChildNodes();
    while (localIterator.hasNext())
      a(paramArrayList, (ITreeNode)localIterator.next());
  }

  public void a(IPackageElement paramIPackageElement, boolean paramBoolean)
  {
    RuleService localRuleService = j();
    String str1 = this.b.b().getUserServer();
    int i = this.b.b().getUserType();
    int j = this.b.b().getUserid();
    if ((str1 == null) || (j == 0) || (i < 2))
      return;
    long l = paramIPackageElement.getModifyTime();
    localRuleService = j();
    localRuleService.put("loginname", str1);
    localRuleService.put("userid", j);
    localRuleService.put("modifytime", new Date(l));
    if (paramIPackageElement.getMainPackage() != null)
      localRuleService.put("exename", paramIPackageElement.getMainPackage().getExeRulePackageName());
    else if (paramIPackageElement.getEnvionment() != null)
      localRuleService.put("exename", paramIPackageElement.getEnvionment().getDisplayName());
    localRuleService.put("parentpath", a(paramIPackageElement.getParent()));
    localRuleService.put("nodename", paramIPackageElement.getDisplayName());
    localRuleService.put("nodetype", paramIPackageElement.getName());
    localRuleService.put("pos", paramIPackageElement.getPos());
    localRuleService.put("modifyuser", str1);
    localRuleService.put("canupdate", paramBoolean);
    localRuleService.put("filecontext", t.b(paramIPackageElement));
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramIPackageElement.getChildNodes();
    while (localIterator.hasNext())
      a(localArrayList, (ITreeNode)localIterator.next());
    localRuleService.put("list", localArrayList);
    localRuleService.execute(this.a + "nodesave");
    String str2 = localRuleService.getString("error");
    if ((str2 == null) || (str2.length() == 0))
      this.b.j().c(paramIPackageElement.getDisplayName() + c.b("success.updatedb"));
    else
      this.b.j().a(paramIPackageElement.getDisplayName() + str2);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.a.h
 * JD-Core Version:    0.6.0
 */