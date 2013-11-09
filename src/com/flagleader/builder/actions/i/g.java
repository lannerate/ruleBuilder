package com.flagleader.builder.actions.i;

import com.flagleader.builder.dialogs.f.a;
import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.rom.IClassObject;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;

class g
  implements ChildAcceptor
{
  g(f paramf, a parama)
  {
  }

  public boolean accept(Object paramObject)
  {
    String str = this.b.a();
    boolean bool1 = this.b.b();
    boolean bool2 = this.b.c();
    if (this.b.g())
    {
      if ((paramObject instanceof IClassObject))
        return f.a(this.a, ((IClassObject)paramObject).getValueType(), str, bool1, bool2);
    }
    else if (this.b.e())
    {
      if (((paramObject instanceof ITreeNode)) && (!(paramObject instanceof IRuleTree)))
        return f.a(this.a, ((ITreeNode)paramObject).getDisplayName(), str, bool1, bool2);
    }
    else if (this.b.d())
    {
      if ((paramObject instanceof IRulePackage))
        return f.a(this.a, ((IRulePackage)paramObject).getDisplayName(), str, bool1, bool2);
    }
    else if ((this.b.f()) && ((paramObject instanceof IRuleTree)))
      return f.a(this.a, ((IRuleTree)paramObject).getDisplayName(), str, bool1, bool2);
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof ITreeNode;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.g
 * JD-Core Version:    0.6.0
 */