package com.flagleader.repository.tree.a;

import com.flagleader.repository.tree.ITreeNode;
import java.util.Hashtable;
import javax.swing.undo.StateEditable;

public class a
  implements StateEditable
{
  private ITreeNode a;
  private ITreeNode b;
  private int c;
  private int d = 0;

  public a(ITreeNode paramITreeNode1, ITreeNode paramITreeNode2, int paramInt)
  {
    this.a = paramITreeNode1;
    this.b = paramITreeNode2;
    this.c = paramInt;
  }

  public void restoreState(Hashtable paramHashtable)
  {
    int i = ((Integer)paramHashtable.get("back")).intValue() % 2;
    if (i == 0)
      this.a.addChildElement(this.b, this.c);
    else
      this.a.removeChildElement(this.b);
    this.a.updateTree();
  }

  public void storeState(Hashtable paramHashtable)
  {
    paramHashtable.put("back", new Integer(this.d++));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.a.a
 * JD-Core Version:    0.6.0
 */