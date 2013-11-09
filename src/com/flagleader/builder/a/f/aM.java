package com.flagleader.builder.a.f;

import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.ITreeNode;

public class aM extends a
{
  public aM(af paramaf)
  {
  }

  public boolean b()
  {
    return !af.a(this.a).isLocked();
  }

  public String c()
  {
    return "RuleOrder";
  }

  public int g()
  {
    return 2;
  }

  public String[] i()
  {
    String[] arrayOfString = new String[af.a(this.a).getMaxPos() - af.a(this.a).getMinPos()];
    for (int i = 0; i < af.a(this.a).getMaxPos() - af.a(this.a).getMinPos(); i++)
      arrayOfString[i] = new Integer(af.a(this.a).getMinPos() + i + 1).toString();
    return arrayOfString;
  }

  public String j()
  {
    return new Integer(af.a(this.a).getPos() + 1).toString();
  }

  public boolean a(int paramInt)
  {
    if (af.a(this.a).getPos() != paramInt)
    {
      af.a(this.a).setPos(paramInt);
      af.a(this.a).setModified(true);
      if ((af.a(this.a).getParent() instanceof ITreeNode))
      {
        ((ITreeNode)af.a(this.a).getParent()).setModified(true);
        ((ITreeNode)af.a(this.a).getParent()).updateTree();
      }
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aM
 * JD-Core Version:    0.6.0
 */