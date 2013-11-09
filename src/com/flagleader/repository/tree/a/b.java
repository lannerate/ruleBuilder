package com.flagleader.repository.tree.a;

import com.flagleader.repository.tree.ITreeNode;
import java.util.Hashtable;
import javax.swing.undo.StateEditable;

public class b
  implements StateEditable
{
  private ITreeNode b;
  private ITreeNode c;
  private int d;
  private int e = 0;
  ITreeNode a;

  public b(ITreeNode paramITreeNode1, ITreeNode paramITreeNode2, int paramInt, ITreeNode paramITreeNode3)
  {
    this.b = paramITreeNode1;
    this.c = paramITreeNode2;
    this.d = paramInt;
    this.a = paramITreeNode3;
  }

  public void restoreState(Hashtable paramHashtable)
  {
    int i = ((Integer)paramHashtable.get("back")).intValue() % 2;
    if (i == 0)
    {
      this.a.removeChildElement(this.c);
      this.b.addChildElement(this.c, this.d);
    }
    else
    {
      this.a.addChildElement(this.c);
      this.b.removeChildElement(this.c);
    }
    this.b.updateTree();
  }

  public void storeState(Hashtable paramHashtable)
  {
    paramHashtable.put("back", new Integer(this.e++));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.a.b
 * JD-Core Version:    0.6.0
 */