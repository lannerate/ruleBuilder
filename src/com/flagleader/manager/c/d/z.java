package com.flagleader.manager.c.d;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.rlm.action.ExcuteRuleToken;
import com.flagleader.repository.rlm.action.ExeRuleToken;
import com.flagleader.repository.rlm.action.SelectRulePackageToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.RulePackage;

class z
  implements ChildAcceptor
{
  z(y paramy, RulePackage paramRulePackage)
  {
  }

  public boolean accept(Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof ExcuteRuleToken))
    {
      localObject = (ValueToken)((ExcuteRuleToken)paramObject).getRuleNameToken();
      if (localObject != null)
      {
        IValueToken localIValueToken = ((ValueToken)localObject).getValueElement();
        if ((localIValueToken instanceof ConstantToken))
          return ((ConstantToken)localIValueToken).getValue().equals(this.b.getExeRulePackageName());
      }
    }
    else if ((paramObject instanceof ExeRuleToken))
    {
      localObject = ((ExeRuleToken)paramObject).getRuleNameToken();
      if ((localObject != null) && (((SelectRulePackageToken)localObject).getExeRuleName().equals(this.b.getExeRulePackageName())))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return (!(paramObject instanceof Envionment)) && (!(paramObject instanceof IMultiConditionToken));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.z
 * JD-Core Version:    0.6.0
 */