package com.flagleader.manager.c.d;

import com.flagleader.manager.builder.b;
import com.flagleader.manager.c.h;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.rlm.action.ExcuteRuleToken;
import com.flagleader.repository.rlm.action.ExeRuleToken;
import com.flagleader.repository.rlm.action.SelectRulePackageToken;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.RulePackage;
import java.util.ArrayList;
import java.util.Iterator;

public class y extends h
{
  public static String[] a = { com.flagleader.manager.d.c.b("notignore.dialog"), com.flagleader.manager.d.c.b("ignore.dialog") };
  public static String[] e = { com.flagleader.manager.d.c.b("stringnull.dialog"), com.flagleader.manager.d.c.b("stringempty.dialog") };
  public static String[] f = { com.flagleader.manager.d.c.b("datenullfault.dialog"), com.flagleader.manager.d.c.b("datenullexception.dialog"), com.flagleader.manager.d.c.b("datenullminimal.dialog"), com.flagleader.manager.d.c.b("datenullnow.dialog") };
  public static String[] g = { com.flagleader.manager.d.c.b("EDITALL.RulePackageProperties"), com.flagleader.manager.d.c.b("EDITSIMPLE.RulePackageProperties"), com.flagleader.manager.d.c.b("EDITTREEFLOW.RulePackageProperties"), com.flagleader.manager.d.c.b("EDITPOOLFLOW.RulePackageProperties"), com.flagleader.manager.d.c.b("EDITRELATEDECISION.RulePackageProperties"), com.flagleader.manager.d.c.b("EDITMULTIDECISION.RulePackageProperties"), com.flagleader.manager.d.c.b("EDITDECISION.RulePackageProperties") };
  public static String[] h = { com.flagleader.manager.d.c.b("weballedit.RulePackagePropertiesEditor"), com.flagleader.manager.d.c.b("webuseredit.RulePackagePropertiesEditor"), com.flagleader.manager.d.c.b("webnoedit.RulePackagePropertiesEditor") };
  public static String[] i = com.flagleader.manager.d.c.d("checktypes.RulePackagePropertiesEditor");
  public static String[] j;
  public static String[] k;
  public static String[] l;
  public static String[] m;
  public static String[] n;

  static
  {
    for (int i1 = 0; i1 < i.length; i1++)
      i[i1] = com.flagleader.manager.d.c.b(i[i1] + ".RulePackagePropertiesEditor");
    j = com.flagleader.manager.d.c.d("locktypes.RulePackagePropertiesEditor");
    for (i1 = 0; i1 < j.length; i1++)
      j[i1] = com.flagleader.manager.d.c.b(j[i1] + ".RulePackagePropertiesEditor");
    k = com.flagleader.manager.d.c.d("logtimes.RuleTreeProperties");
    for (i1 = 0; i1 < k.length; i1++)
      k[i1] = com.flagleader.manager.d.c.b(k[i1] + ".RuleTreeProperties");
    l = com.flagleader.manager.d.c.d("vmlFlowTypes.RulePackagePropertiesEditor");
    for (i1 = 0; i1 < l.length; i1++)
      l[i1] = com.flagleader.manager.d.c.b(l[i1] + ".RulePackagePropertiesEditor");
    m = com.flagleader.manager.d.c.d("logdbtypes.RulePackagePropertiesEditor");
    for (i1 = 0; i1 < m.length; i1++)
      m[i1] = com.flagleader.manager.d.c.b(m[i1] + ".RulePackagePropertiesEditor");
    n = com.flagleader.manager.d.c.d("logtypes.RulePackagePropertiesEditor");
    for (i1 = 0; i1 < n.length; i1++)
      n[i1] = com.flagleader.manager.d.c.b(n[i1] + ".RulePackagePropertiesEditor");
  }

  public y(com.flagleader.manager.c.c paramc, RulePackage paramRulePackage, r paramr)
  {
    super(paramc, paramRulePackage, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), c().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("modifyuser.dialog"), c().getModifyUser());
    a(com.flagleader.manager.d.c.b("vmlFlowType.RulePackagePropertiesEditor"), new T(this));
    if (c().isDeveloper())
    {
      a(com.flagleader.manager.d.c.b("version.dialog"), new S(this));
      a(com.flagleader.manager.d.c.b("projver.dialog"), new M(this));
      a(com.flagleader.manager.d.c.b("name.dialog"), new l(this));
      a(com.flagleader.manager.d.c.b("exepackagename.dialog"), new E(this));
      a(com.flagleader.manager.d.c.b("mainversion.dialog"), new K(this));
      if (!this.d.b().isPlugInApp())
      {
        a(com.flagleader.manager.d.c.b("ruleid.dialog"), new O(this));
        a(com.flagleader.manager.d.c.b("lockType.dialog"), j[c().getLockType()]);
        a(com.flagleader.manager.d.c.b("webrole.RulePackagePropertiesEditor"), new U(this));
        a(com.flagleader.manager.d.c.b("ruleeditlevel.RulePackageProperties"), new N(this));
        a(com.flagleader.manager.d.c.b("checkType.dialog"), i[c().getCheckType()]);
        a(com.flagleader.manager.d.c.b("packagedir.dialog"), new L(this));
        a(com.flagleader.manager.d.c.b("exepackagedir.dialog"), new F(this));
        a(com.flagleader.manager.d.c.b("order.dialog"), new m(this));
      }
      a(com.flagleader.manager.d.c.b("stringignore.dialog"), new Q(this));
      a(com.flagleader.manager.d.c.b("stringinit.dialog"), new R(this));
      a(com.flagleader.manager.d.c.b("datenull.dialog"), new C(this));
      a(com.flagleader.manager.d.c.b("packlogtype.RulePackagePropertiesEditor"), new I(this));
      a(com.flagleader.manager.d.c.b("packlogdb.RulePackagePropertiesEditor"), new J(this));
      a(com.flagleader.manager.d.c.b("needlogtime.RuleTreeProperties"), new H(this));
      a(com.flagleader.manager.d.c.b("checkSubRuleType.RuleTreeProperties"), new A(this));
      a(com.flagleader.manager.d.c.b("startTime.dialog"), new P(this));
      a(com.flagleader.manager.d.c.b("endTime.dialog"), new D(this));
    }
    else
    {
      a(com.flagleader.manager.d.c.b("version.dialog"), c().getVersion());
    }
  }

  private RulePackage c()
  {
    if ((d() != null) && ((d() instanceof RulePackage)))
      return (RulePackage)d();
    return null;
  }

  private void a(String paramString)
  {
    RulePackage localRulePackage = c();
    IRuleRepository localIRuleRepository = e().d();
    if (localIRuleRepository != null)
    {
      Iterator localIterator = localIRuleRepository.getAcceptElements(new z(this, localRulePackage));
      ArrayList localArrayList = new ArrayList();
      while (localIterator.hasNext())
        localArrayList.add(localIterator.next());
      if (localArrayList.size() > 0)
        if (e().b().showQuestion(com.flagleader.manager.d.c.a("searchpackexe.RulePackageProperties", new String[] { String.valueOf(localArrayList.size()) })))
          for (int i1 = 0; i1 < localArrayList.size(); i1++)
          {
            Object localObject1 = localArrayList.get(i1);
            Object localObject2;
            if ((localObject1 instanceof ExcuteRuleToken))
            {
              localObject2 = (ValueToken)((ExcuteRuleToken)localObject1).getRuleNameToken();
              if (localObject2 == null)
                continue;
              IValueToken localIValueToken = ((ValueToken)localObject2).getValueElement();
              if ((localIValueToken instanceof ConstantToken))
                ((ConstantToken)localIValueToken).setValue(paramString);
              ((ValueToken)localObject2).getRoot().setModified(true);
            }
            else
            {
              if (!(localObject1 instanceof ExeRuleToken))
                continue;
              localObject2 = ((ExeRuleToken)localObject1).getRuleNameToken();
              ((SelectRulePackageToken)localObject2).setExeRuleName(paramString);
              ((SelectRulePackageToken)localObject2).getRoot().setModified(true);
            }
          }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.y
 * JD-Core Version:    0.6.0
 */