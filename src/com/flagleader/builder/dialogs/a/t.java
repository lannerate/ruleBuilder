package com.flagleader.builder.dialogs.a;

import com.flagleader.builder.ResourceTools;
import com.flagleader.repository.l;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.rom.ISubVariable;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class t extends KeyAdapter
{
  t(s params)
  {
  }

  public void keyReleased(KeyEvent paramKeyEvent)
  {
    super.keyReleased(paramKeyEvent);
    if (paramKeyEvent.keyCode == 16777218)
    {
      s.a(this.a);
      return;
    }
    if (paramKeyEvent.keyCode == 16777217)
    {
      s.b(this.a);
      return;
    }
    if (!s.c(this.a).getText().equals(s.d(this.a)))
    {
      if (s.c(this.a).getText().startsWith(s.d(this.a)))
      {
        s.a(this.a, s.e(this.a).getItems(), s.c(this.a).getText());
      }
      else
      {
        s.e(this.a).removeAll();
        for (int i = 0; i < s.f(this.a).length; i++)
        {
          TreeItem localTreeItem = new TreeItem(s.e(this.a), 0);
          localTreeItem.setText(0, s.f(this.a)[i].b());
          if ((s.f(this.a)[i].e() instanceof ITreeNode))
            localTreeItem.setImage(s.a(this.a, (ITreeNode)s.f(this.a)[i].e()));
          else if ((s.f(this.a)[i].e() instanceof ISubFunction))
            localTreeItem.setImage(ResourceTools.getImage("classsubfunction.icon"));
          else if ((s.f(this.a)[i].e() instanceof ISubVariable))
            localTreeItem.setImage(ResourceTools.getImage("classsubvariable.icon"));
          else if ((s.f(this.a)[i].e() instanceof IFunctionObject))
            localTreeItem.setImage(ResourceTools.getImage("classfunction.icon"));
          else if ((s.f(this.a)[i].e() instanceof IVariableObject))
            localTreeItem.setImage(ResourceTools.getImage("classvariable.icon"));
          if ((s.f(this.a)[i].e() instanceof IBusinessObject))
            localTreeItem.setText(1, ((IBusinessObject)s.f(this.a)[i].e()).getValueName());
          if (s.f(this.a)[i].c())
            s.a(this.a, s.f(this.a)[i], localTreeItem);
          else
            localTreeItem.setData(s.f(this.a)[i]);
        }
        s.a(this.a, s.e(this.a).getItems(), s.c(this.a).getText());
      }
      s.a(this.a, s.c(this.a).getText());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.t
 * JD-Core Version:    0.6.0
 */