package com.flagleader.builder.a.b;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.rlm.action.ExeRuleToken;
import com.flagleader.repository.rlm.action.PackageFieldGet;
import com.flagleader.repository.rlm.action.PackageFieldSet;
import com.flagleader.repository.rlm.action.SelectRulePackageToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRulePackage;
import java.util.List;

class k
  implements ChildAcceptor
{
  k(e parame, IRulePackage paramIRulePackage, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    if ((paramObject instanceof ExeRuleToken))
    {
      SelectRulePackageToken localSelectRulePackageToken = ((ExeRuleToken)paramObject).getRuleNameToken();
      if ((localSelectRulePackageToken != null) && (localSelectRulePackageToken.getExeRuleName().equals(this.b.getExeRulePackageName())))
      {
        List localList = localSelectRulePackageToken.getSelectedFields();
        Object localObject;
        for (int i = 0; i < localList.size(); i++)
        {
          localObject = (PackageFieldGet)localList.get(i);
          if (((PackageFieldGet)localObject).getFuncName().equals(this.c))
            return true;
        }
        localList = localSelectRulePackageToken.getSelectedWheres();
        for (i = 0; i < localList.size(); i++)
        {
          localObject = (PackageFieldSet)localList.get(i);
          if (((PackageFieldSet)localObject).getFuncName().equals(this.c))
            return true;
        }
      }
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return (!(paramObject instanceof Envionment)) && (!(paramObject instanceof IMultiConditionToken));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.k
 * JD-Core Version:    0.6.0
 */