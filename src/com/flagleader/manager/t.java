package com.flagleader.manager;

import com.flagleader.manager.e.B;
import com.flagleader.manager.e.D;
import com.flagleader.manager.e.F;
import com.flagleader.manager.e.I;
import com.flagleader.manager.e.K;
import com.flagleader.manager.e.N;
import com.flagleader.manager.e.Q;
import com.flagleader.manager.e.S;
import com.flagleader.manager.e.W;
import com.flagleader.manager.e.X;
import com.flagleader.manager.e.a;
import com.flagleader.manager.e.c;
import com.flagleader.manager.e.e;
import com.flagleader.manager.e.h;
import com.flagleader.manager.e.j;
import com.flagleader.manager.e.l;
import com.flagleader.manager.e.p;
import com.flagleader.manager.e.v;
import com.flagleader.manager.e.y;
import com.flagleader.manager.e.z;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.tree.CheckRuleInfo;
import com.flagleader.repository.tree.IOpenNode;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class t
{
  HashMap a = new HashMap();
  List b = new ArrayList();
  private r c = null;

  public t(r paramr)
  {
    this.c = paramr;
  }

  private void a(W paramW)
  {
    this.a.put(paramW.b(), paramW);
    paramW.a(this);
    a(paramW);
  }

  private W a(String paramString)
  {
    return (W)this.a.get(paramString);
  }

  public void a(y paramy)
  {
    this.b.add(paramy);
  }

  public void a(z paramz)
  {
    for (int i = 0; i < this.b.size(); i++)
      ((y)this.b.get(i)).a(paramz);
  }

  public W a(IRulePackage paramIRulePackage, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(paramIRulePackage.getUuid() + l.class.getName() + paramString);
    if (localObject == null)
    {
      localObject = new l(paramIRulePackage, paramString, paramBoolean1);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    if ((paramBoolean2) || (((W)localObject).d() < paramIRulePackage.getMaxModifyTime()))
    {
      ((W)localObject).f();
      localObject = new l(paramIRulePackage, paramString, paramBoolean1);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    return (W)localObject;
  }

  public W a(IRuleGroup paramIRuleGroup, String paramString, boolean paramBoolean)
  {
    Object localObject = a(paramIRuleGroup.getUuid() + X.class.getName() + paramString);
    if (localObject == null)
    {
      localObject = new X(paramIRuleGroup, paramString);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    if ((paramBoolean) || (((W)localObject).d() < paramIRuleGroup.getMaxModifyTime()))
    {
      ((W)localObject).f();
      localObject = new X(paramIRuleGroup, paramString);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    return (W)localObject;
  }

  public W b(IRuleGroup paramIRuleGroup, String paramString, boolean paramBoolean)
  {
    Object localObject = a(paramIRuleGroup.getUuid() + p.class.getName() + paramString);
    if (localObject == null)
    {
      localObject = new p(paramIRuleGroup, paramString);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    if ((paramBoolean) || (((W)localObject).d() < paramIRuleGroup.getMaxModifyTime()))
    {
      ((W)localObject).f();
      localObject = new p(paramIRuleGroup, paramString);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    return (W)localObject;
  }

  public W c(IRuleGroup paramIRuleGroup, String paramString, boolean paramBoolean)
  {
    Object localObject = a(paramIRuleGroup.getUuid() + j.class.getName() + paramString);
    if (localObject == null)
    {
      localObject = new j(paramIRuleGroup, paramString);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    if ((paramBoolean) || (((W)localObject).d() < paramIRuleGroup.getMaxModifyTime()))
    {
      ((W)localObject).f();
      localObject = new j(paramIRuleGroup, paramString);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    return (W)localObject;
  }

  public W a(IPackageElement paramIPackageElement, String paramString, List paramList, boolean paramBoolean)
  {
    Object localObject = a(paramIPackageElement.getUuid() + B.class.getName() + paramString);
    if (localObject == null)
    {
      localObject = new B(paramIPackageElement, paramString, paramList);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    if ((paramBoolean) || (((W)localObject).d() < paramIPackageElement.getMaxModifyTime()))
    {
      ((W)localObject).f();
      localObject = new B(paramIPackageElement, paramString, paramList);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    return (W)localObject;
  }

  public W b(IPackageElement paramIPackageElement, String paramString, List paramList, boolean paramBoolean)
  {
    Object localObject = a(paramIPackageElement.getUuid() + D.class.getName() + paramString);
    if (localObject == null)
    {
      localObject = new D(paramIPackageElement, paramString, paramList);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    if ((paramBoolean) || (((W)localObject).d() < paramIPackageElement.getMaxModifyTime()))
    {
      ((W)localObject).f();
      localObject = new D(paramIPackageElement, paramString, paramList);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    return (W)localObject;
  }

  public W a(SheetTable paramSheetTable, String paramString, boolean paramBoolean)
  {
    Object localObject = a(paramSheetTable.getUuid() + F.class.getName() + paramString);
    if (localObject == null)
    {
      localObject = new F(paramSheetTable, paramString);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    if ((paramBoolean) || (((W)localObject).d() < paramSheetTable.getMaxModifyTime()))
    {
      ((W)localObject).f();
      localObject = new F(paramSheetTable, paramString);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    return (W)localObject;
  }

  public W a(IRulePackage paramIRulePackage, String paramString, boolean paramBoolean)
  {
    Object localObject = a(paramIRulePackage.getUuid() + h.class.getName());
    if (localObject == null)
    {
      localObject = new h(paramIRulePackage, paramString);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    if ((paramBoolean) || (((W)localObject).d() < paramIRulePackage.getMaxModifyTime()))
    {
      ((W)localObject).f();
      localObject = new h(paramIRulePackage, paramString);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    return (W)localObject;
  }

  public W a(IRulePackage paramIRulePackage)
  {
    Object localObject = a(paramIRulePackage.getUuid() + a.class.getName());
    if (localObject == null)
    {
      localObject = new a(paramIRulePackage);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    ((W)localObject).f();
    localObject = new a(paramIRulePackage);
    a((W)localObject);
    ((W)localObject).g();
    return (W)localObject;
  }

  public W a(IOpenNode paramIOpenNode)
  {
    Object localObject = a(paramIOpenNode.getUuid() + c.class.getName());
    if (localObject == null)
    {
      localObject = new c(paramIOpenNode);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    ((W)localObject).f();
    localObject = new c(paramIOpenNode);
    a((W)localObject);
    ((W)localObject).g();
    return (W)localObject;
  }

  public W a(IPackageElement paramIPackageElement, boolean paramBoolean)
  {
    Object localObject = a(paramIPackageElement.getUuid() + e.class.getName());
    if (localObject == null)
    {
      localObject = new e(paramIPackageElement, paramBoolean);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    ((W)localObject).f();
    localObject = new e(paramIPackageElement, paramBoolean);
    a((W)localObject);
    ((W)localObject).g();
    return (W)localObject;
  }

  public W a(IPage paramIPage, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(paramIPage.getUuid() + com.flagleader.manager.e.n.class.getName() + paramString);
    if (localObject == null)
    {
      localObject = new com.flagleader.manager.e.n(paramIPage, paramString, paramBoolean1);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    if ((paramBoolean2) || (((W)localObject).d() < paramIPage.getMaxModifyTime()))
    {
      ((W)localObject).f();
      localObject = new com.flagleader.manager.e.n(paramIPage, paramString, paramBoolean1);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    return (W)localObject;
  }

  public W a(IRulePackage paramIRulePackage, String paramString)
  {
    Object localObject = a(paramIRulePackage.getUuid() + com.flagleader.manager.e.r.class.getName() + paramString);
    if (localObject == null)
    {
      localObject = new com.flagleader.manager.e.r(paramIRulePackage, paramString);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    ((W)localObject).f();
    localObject = new com.flagleader.manager.e.r(paramIRulePackage, paramString);
    a((W)localObject);
    ((W)localObject).g();
    return (W)localObject;
  }

  public W a(IPage paramIPage, String paramString)
  {
    Object localObject = a(paramIPage.getUuid() + com.flagleader.manager.e.t.class.getName() + paramString);
    if (localObject == null)
    {
      localObject = new com.flagleader.manager.e.t(paramIPage, paramString);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    ((W)localObject).f();
    localObject = new com.flagleader.manager.e.t(paramIPage, paramString);
    a((W)localObject);
    ((W)localObject).g();
    return (W)localObject;
  }

  public W b(IRulePackage paramIRulePackage)
  {
    Object localObject = a(paramIRulePackage.getUuid() + v.class.getName());
    if (localObject == null)
    {
      localObject = new v(paramIRulePackage);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    ((W)localObject).f();
    localObject = new v(paramIRulePackage);
    a((W)localObject);
    ((W)localObject).g();
    return (W)localObject;
  }

  public W a(TestCase paramTestCase)
  {
    Object localObject = a(paramTestCase.getUuid() + K.class.getName());
    if (localObject == null)
    {
      localObject = new K(paramTestCase, this.c.m().a());
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    if (((W)localObject).i())
    {
      localObject = new K(paramTestCase, this.c.m().a());
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    return (W)localObject;
  }

  public W a(TestCaseLib paramTestCaseLib)
  {
    Object localObject = a(paramTestCaseLib.getUuid() + K.class.getName());
    if (localObject == null)
    {
      localObject = new I(paramTestCaseLib, this.c.m().a());
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    if (((W)localObject).i())
    {
      localObject = new I(paramTestCaseLib, this.c.m().a());
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    return (W)localObject;
  }

  public W a(CheckRuleInfo paramCheckRuleInfo)
  {
    Object localObject = a(paramCheckRuleInfo.getUuid() + K.class.getName());
    if (localObject == null)
    {
      localObject = new N(paramCheckRuleInfo, this.c.m().a());
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    if (((W)localObject).i())
    {
      localObject = new N(paramCheckRuleInfo, this.c.m().a());
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    return (W)localObject;
  }

  public W a(IRuleClass paramIRuleClass, HashMap paramHashMap, String paramString)
  {
    Object localObject = a(paramIRuleClass.getUuid() + S.class.getName());
    if (localObject == null)
    {
      if ((paramIRuleClass instanceof IRuleTree))
        localObject = new Q((IRuleTree)paramIRuleClass, this.c.m().a(), paramHashMap);
      else
        localObject = new S(paramIRuleClass, this.c.m().a(), paramHashMap, paramString);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    if (((W)localObject).d() < paramIRuleClass.getMaxModifyTime())
    {
      ((W)localObject).f();
      if ((paramIRuleClass instanceof IRuleTree))
        localObject = new Q((IRuleTree)paramIRuleClass, this.c.m().a(), paramHashMap);
      else
        localObject = new S(paramIRuleClass, this.c.m().a(), paramHashMap, paramString);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    if (((W)localObject).i())
    {
      if ((paramIRuleClass instanceof IRuleTree))
        localObject = new Q((IRuleTree)paramIRuleClass, this.c.m().a(), paramHashMap);
      else
        localObject = new S(paramIRuleClass, this.c.m().a(), paramHashMap, paramString);
      a((W)localObject);
      ((W)localObject).g();
      return localObject;
    }
    return (W)localObject;
  }

  public r a()
  {
    return this.c;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.t
 * JD-Core Version:    0.6.0
 */