package com.flagleader.repository.tree.a;

import com.flagleader.repository.tree.ITreeNode;
import java.util.Hashtable;
import javax.swing.undo.StateEditable;

public class d
  implements StateEditable
{
  private ITreeNode a;
  private String b;
  private int c = 0;
  private String d;

  public d(ITreeNode paramITreeNode, String paramString1, String paramString2)
  {
    this.a = paramITreeNode;
    this.b = paramString1;
    this.d = paramString2;
  }

  public void restoreState(Hashtable paramHashtable)
  {
    int i = ((Integer)paramHashtable.get("back")).intValue() % 2;
    if (i == 0)
      this.a.setDisplayName(this.b);
    else
      this.a.setDisplayName(this.d);
    this.a.updateText();
  }

  public void storeState(Hashtable paramHashtable)
  {
    paramHashtable.put("back", new Integer(this.c++));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.a.d
 * JD-Core Version:    0.6.0
 */