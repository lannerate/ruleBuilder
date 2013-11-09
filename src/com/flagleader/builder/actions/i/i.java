package com.flagleader.builder.actions.i;

import com.flagleader.builder.dialogs.f.b;
import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.IRuleTree;

class i
  implements ChildAcceptor
{
  i(h paramh, b paramb)
  {
  }

  public boolean accept(Object paramObject)
  {
    String str = this.b.a();
    boolean bool1 = this.b.b();
    boolean bool2 = this.b.c();
    if (this.b.g())
    {
      if ((paramObject instanceof IBusinessObject))
        return h.a(this.a, ((IBusinessObject)paramObject).getVarValue(), str, bool1, bool2);
    }
    else if (this.b.e())
    {
      if ((paramObject instanceof IBusinessObject))
        return h.a(this.a, ((IBusinessObject)paramObject).getDisplayName(), str, bool1, bool2);
    }
    else if (this.b.d())
    {
      if ((paramObject instanceof IBusinessObject))
        return h.a(this.a, ((IBusinessObject)paramObject).getValueName(), str, bool1, bool2);
    }
    else if ((this.b.f()) && ((paramObject instanceof IBusinessObject)))
      return h.a(this.a, ((IBusinessObject)paramObject).getValueType(), str, bool1, bool2);
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return !(paramObject instanceof IRuleTree);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.i
 * JD-Core Version:    0.6.0
 */