package com.flagleader.builder.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.actions.bm;
import com.flagleader.builder.widget.p;
import com.flagleader.manager.d.c;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public abstract class v
  implements IElementViewer
{
  protected bu b;
  protected Composite c;
  protected ITreeNode d;
  protected long e = 0L;
  protected String f = "";
  protected boolean g = true;

  public v(ITreeNode paramITreeNode, Composite paramComposite, bu parambu)
  {
    this.b = parambu;
    this.c = paramComposite;
    this.d = paramITreeNode;
    if (parambu.i().getWindowsManager().h())
    {
      this.f = (paramITreeNode.getEditUuid() + "props");
      this.g = true;
    }
    else
    {
      this.f = (paramITreeNode.getEditUuid() + "props1");
      this.g = false;
    }
    paramITreeNode.addViewer(this);
    c(paramComposite);
  }

  protected Composite c(Composite paramComposite)
  {
    SashForm localSashForm = new SashForm(paramComposite, 512);
    GridData localGridData = new GridData(1808);
    localSashForm.setLayoutData(localGridData);
    a(localSashForm);
    d(localSashForm);
    if (this.g)
      localSashForm.setWeights(new int[] { 80, 20 });
    else
      localSashForm.setWeights(new int[] { 100 });
    return localSashForm;
  }

  protected Composite a(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.verticalSpacing = 0;
    localComposite.setLayout(localGridLayout);
    localComposite.setLayoutData(new GridData(1808));
    return localComposite;
  }

  protected Composite d(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(new FillLayout());
    e(localComposite);
    return localComposite;
  }

  protected Text e(Composite paramComposite)
  {
    Text localText = new p(c()).a(paramComposite, 2882);
    localText.setText(d().getDocument());
    if (d().isLocked())
      localText.setEditable(false);
    else
      localText.addModifyListener(new w(this, localText));
    return localText;
  }

  public bu b()
  {
    return this.b;
  }

  public BuilderManager c()
  {
    if (this.b != null)
      return this.b.i();
    return null;
  }

  public ITreeNode d()
  {
    return this.d;
  }

  public void update()
  {
    this.e = System.currentTimeMillis();
  }

  public Shell e()
  {
    return this.c.getShell();
  }

  public boolean needUpdate()
  {
    return (this.e == 0L) || (this.e < this.d.getModifyTime());
  }

  public void dispose()
  {
    this.d.removeViewer(this);
    this.b.a(this.f, this.c);
  }

  protected String a(String paramString, Object[] paramArrayOfObject)
  {
    return ResourceTools.formatMessage(paramString, paramArrayOfObject);
  }

  protected boolean f()
  {
    if (this.d.isLocked())
      return true;
    return c.g(this.d.getName());
  }

  public boolean canCopy()
  {
    return false;
  }

  public boolean canCut()
  {
    return false;
  }

  public boolean canDelete()
  {
    return false;
  }

  public boolean canPaste()
  {
    return false;
  }

  public boolean g()
  {
    return false;
  }

  public boolean canRedo()
  {
    return false;
  }

  public boolean canUndo()
  {
    return false;
  }

  public void copy()
  {
  }

  public void cut()
  {
  }

  public void delete()
  {
  }

  public boolean paste()
  {
    return false;
  }

  public void h()
  {
  }

  public boolean redo()
  {
    return false;
  }

  public void selectAll()
  {
  }

  public boolean undo()
  {
    return false;
  }

  public void find()
  {
  }

  public void findNext()
  {
  }

  public boolean isCanFind()
  {
    return false;
  }

  public boolean isCanSelectAll()
  {
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.c.v
 * JD-Core Version:    0.6.0
 */