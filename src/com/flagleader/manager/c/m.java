package com.flagleader.manager.c;

import com.flagleader.manager.c.c.g;
import com.flagleader.repository.tree.ITreeNode;

public class m
  implements g
{
  public m(h paramh)
  {
  }

  public String[] a()
  {
    String[] arrayOfString = new String[this.a.d().getMaxPos() - this.a.d().getMinPos()];
    for (int i = 0; i < this.a.d().getMaxPos() - this.a.d().getMinPos(); i++)
      arrayOfString[i] = new Integer(this.a.d().getMinPos() + i + 1).toString();
    return arrayOfString;
  }

  public String b()
  {
    return new Integer(this.a.d().getPos() + 1).toString();
  }

  public boolean a(String paramString)
  {
    if (this.a.d().getPos() != Integer.parseInt(paramString.toString()) - 1)
    {
      this.a.d().setPos(Integer.parseInt(paramString.toString()) - 1);
      this.a.d().setModified(true);
      if ((this.a.d().getParent() instanceof ITreeNode))
      {
        ((ITreeNode)this.a.d().getParent()).setModified(true);
        ((ITreeNode)this.a.d().getParent()).updateTree();
      }
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.m
 * JD-Core Version:    0.6.0
 */