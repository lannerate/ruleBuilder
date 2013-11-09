package com.flagleader.builder.a.f;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.widget.d;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.flow.RulePoolNode;
import com.flagleader.repository.tree.Envionment;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;

public class bu extends aS
  implements IElementViewer
{
  private RulePoolFlow f;
  private Graph g;
  boolean e = false;
  private boolean q = false;
  private Menu r;
  private String s = "";
  private int t = 0;
  private GraphNode u;

  public bu(RulePoolFlow paramRulePoolFlow, Composite paramComposite, com.flagleader.builder.a.bu parambu)
  {
    super(paramRulePoolFlow, paramComposite, parambu);
    this.f = paramRulePoolFlow;
  }

  protected aS e(Composite paramComposite)
  {
    return new bu((RulePoolFlow)this.c, paramComposite, this.a);
  }

  protected void a(ToolBar paramToolBar)
  {
    super.a(paramToolBar);
  }

  protected void h()
  {
    super.h();
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    this.g = new Graph(localComposite, 0);
    this.g.setLayoutData(new GridData(1808));
    this.g.setConnectionStyle(2);
    this.g.addFocusListener(new bv(this));
    DropTarget localDropTarget = new DropTarget(this.g, 19);
    localDropTarget.setTransfer(new Transfer[] { TextTransfer.getInstance(), d.a() });
    localDropTarget.addDropListener(new bw(this));
    this.g.addMouseListener(new bx(this));
    return localComposite;
  }

  private GraphNode a(IFigure paramIFigure)
  {
    List localList = this.g.getNodes();
    for (int i = localList.size() - 1; i >= 0; i--)
    {
      GraphNode localGraphNode = (GraphNode)localList.get(i);
      if (localGraphNode.getNodeFigure().equals(paramIFigure))
        return localGraphNode;
    }
    return null;
  }

  private void a(RulePoolNode paramRulePoolNode)
  {
    GraphNode localGraphNode = new GraphNode(this.g, 0, paramRulePoolNode.getDisplayName(), b(paramRulePoolNode));
    localGraphNode.setLocation(paramRulePoolNode.getX(), paramRulePoolNode.getY());
    localGraphNode.setData(paramRulePoolNode);
    paramRulePoolNode.setWidth(localGraphNode.getSize().width);
    paramRulePoolNode.setHeight(localGraphNode.getSize().height);
    GraphConnection localGraphConnection = new GraphConnection(this.g, 0, this.u, localGraphNode);
  }

  private Image b(RulePoolNode paramRulePoolNode)
  {
    return ResourceTools.getImage(paramRulePoolNode.getImageName() + ".icon");
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    List localList = this.g.getNodes();
    for (int i = localList.size() - 1; i >= 0; i--)
    {
      localObject = (GraphNode)localList.get(i);
      if (((GraphNode)localObject).isDisposed())
        continue;
      ((GraphNode)localObject).dispose();
    }
    RulePoolNode localRulePoolNode1 = this.f.getStartTransitions();
    this.u = new GraphNode(this.g, 0, localRulePoolNode1.getDisplayName(), b(localRulePoolNode1));
    this.u.setLocation(localRulePoolNode1.getX(), localRulePoolNode1.getY());
    this.u.setData(localRulePoolNode1);
    localRulePoolNode1.setWidth(this.u.getSize().width);
    localRulePoolNode1.setHeight(this.u.getSize().height);
    Object localObject = this.f.getChildrenList();
    for (int j = 0; j < ((List)localObject).size(); j++)
    {
      if (!(((List)localObject).get(j) instanceof RulePoolNode))
        continue;
      RulePoolNode localRulePoolNode2 = (RulePoolNode)((List)localObject).get(j);
      if (localRulePoolNode2.isStartNode())
        continue;
      a(localRulePoolNode2);
    }
    this.g.redraw();
    super.update();
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < this.f.getMaxModifyTime()) || (this.d < this.f.getEnvionment().getMaxModifyTime());
  }

  private static Point b(Control paramControl)
  {
    int i = paramControl.getLocation().x;
    int j = paramControl.getLocation().y;
    while (paramControl.getParent() != null)
    {
      paramControl = paramControl.getParent();
      i += paramControl.getLocation().x;
      j += paramControl.getLocation().y;
    }
    return new Point(i, j);
  }

  public String getCompositeUuid()
  {
    return this.f.getEditUuid() + "tree";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bu
 * JD-Core Version:    0.6.0
 */