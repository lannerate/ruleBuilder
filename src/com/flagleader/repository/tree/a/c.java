package com.flagleader.repository.tree.a;

import com.flagleader.repository.tree.ITreeNode;
import java.util.Hashtable;
import javax.swing.undo.StateEditable;

public class c
  implements StateEditable
{
  private ITreeNode a;
  private ITreeNode b;
  private int c = 0;

  public c(ITreeNode paramITreeNode1, ITreeNode paramITreeNode2)
  {
    this.a = paramITreeNode1;
    this.b = paramITreeNode2;
  }

  public void restoreState(Hashtable paramHashtable)
  {
    int i = ((Integer)paramHashtable.get("back")).intValue() % 2;
    if (i == 0)
      this.a.removeChildElement(this.b);
    else
      this.a.paste(this.b);
    this.a.updateTree();
  }

  public void storeState(Hashtable paramHashtable)
  {
    paramHashtable.put("back", new Integer(this.c++));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.a.c
 * JD-Core Version:    0.6.0
 */