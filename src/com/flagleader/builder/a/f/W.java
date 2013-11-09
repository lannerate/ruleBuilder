package com.flagleader.builder.a.f;

import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.ITreeNode;

public class W extends a
{
  public W(o paramo)
  {
  }

  public boolean b()
  {
    return !o.a(this.a).isLocked();
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
    String[] arrayOfString = new String[o.a(this.a).getMaxPos() - o.a(this.a).getMinPos()];
    for (int i = 0; i < o.a(this.a).getMaxPos() - o.a(this.a).getMinPos(); i++)
      arrayOfString[i] = new Integer(o.a(this.a).getMinPos() + i + 1).toString();
    return arrayOfString;
  }

  public String j()
  {
    return new Integer(o.a(this.a).getPos() + 1).toString();
  }

  public boolean a(int paramInt)
  {
    if (o.a(this.a).getPos() != paramInt)
    {
      o.a(this.a).setPos(paramInt);
      o.a(this.a).setModified(true);
      if ((o.a(this.a).getParent() instanceof ITreeNode))
      {
        ((ITreeNode)o.a(this.a).getParent()).setModified(true);
        ((ITreeNode)o.a(this.a).getParent()).updateTree();
      }
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.W
 * JD-Core Version:    0.6.0
 */